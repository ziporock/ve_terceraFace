package ve.controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import ve.modelo.Rol;
import ve.modelo.Usuario;
import ve.modelo.dao.UsuarioDAO;
import ve.modelo.dao.impl.RolDAOImpl;
import ve.modelo.dao.impl.UsuarioDAOImpl;

public class ControladorLogueoUsuarios {

	private UsuarioDAO usuarioDAO;
	
	public boolean ingresarUsuario(String user, String pass){
		
		cargarRolUsuario();
		
		usuarioDAO=new UsuarioDAOImpl();
		Usuario usuario=usuarioDAO.obtenerUsuario(user, encriptarMD5(pass));
		
		if(usuario!=null){
			return true;
		}
		return false;
		
	}
	
	
	public String encriptarMD5(String contrasenia) {
		String password = contrasenia;

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Error");
		}
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		return sb.toString();
	}

	
	public void cargarRolUsuario(){
		
		RolDAOImpl rolDAOImpl=new RolDAOImpl();
		
		Rol rol=new Rol();
		rol.setCodigo("2");
		rol.setDescripcion("Presidente Mesa");
		rolDAOImpl.guardar(rol);
		
		
		Rol rol2=new Rol();
		rol2.setCodigo("3");
		rol2.setDescripcion("Votante");
		rolDAOImpl.guardar(rol2);
		
		
		Usuario usuario=new Usuario();
		usuario.setNombre("nombre 1");
		usuario.setApellido("apellido 1");
		usuario.setNombreUsuario("user");
		usuario.setContrasenia(encriptarMD5("user"));
		usuario.setRol(rol);
		
		
		UsuarioDAOImpl usuarioDAOImpl=new UsuarioDAOImpl();
		usuarioDAOImpl.guardar(usuario);
		
	}

	
}

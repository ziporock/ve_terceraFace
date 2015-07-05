package ve.modelo.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;

import ve.modelo.Rol;
import ve.modelo.Usuario;
import ve.modelo.dao.UsuarioDAO;
import ve.modelo.dao.impl.RolDAOImpl;

public class UsuarioDAOImplMock implements UsuarioDAO {

	private Usuario usuario;

	public void cargarRolUsuario() {

		RolDAOImpl rolDAOImpl = new RolDAOImpl();

		Rol rol = new Rol();
		rol.setCodigo("2");
		rol.setDescripcion("Presidente Mesa");
		rolDAOImpl.guardar(rol);

		Rol rol2 = new Rol();
		rol2.setCodigo("3");
		rol2.setDescripcion("Votante");
		rolDAOImpl.guardar(rol2);

		usuario.setNombre("nombre 1");
		usuario.setApellido("apellido 1");
		usuario.setNombreUsuario("user");
		usuario.setContrasenia("user");
		usuario.setRol(rol);

	}

	@Override
	public void guardar(Object entidad) throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardarList(List entidad) throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(Object entidad) throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Object entidad) throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getById(Object clase, Long id) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAll(Object clase) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obtenerUsuario(String usuario, String contrasenia)
			throws HibernateException {
		cargarRolUsuario();
		return this.usuario;
	}

}

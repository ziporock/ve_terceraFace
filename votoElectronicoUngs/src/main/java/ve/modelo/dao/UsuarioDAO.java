package ve.modelo.dao;

import org.hibernate.HibernateException;

import ve.modelo.Usuario;

public interface UsuarioDAO extends EntidadDAO {

	Usuario obtenerUsuario(String usuario, String contrasenia)throws HibernateException;
}

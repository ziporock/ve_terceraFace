package ve.modelo.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import ve.modelo.Usuario;
import ve.modelo.dao.UsuarioDAO;

public class UsuarioDAOImpl extends EntidadDAOImpl<Usuario> implements UsuarioDAO{

	@Override
	public Usuario obtenerUsuario(String usuario, String contrasenia)
			throws HibernateException {
		
		logger.info("obtenerUsuario: " + Usuario.class);

		Usuario user = null;
		try {
			iniciaConexion();
			Criteria criteria = this.getSession().createCriteria(Usuario.class);
			criteria.add(Restrictions.eq("contrasenia", contrasenia));
			user = (Usuario) criteria.uniqueResult();

		} catch (HibernateException e) {
			logger.error("Error al obtener usuario con: " + usuario + "contrasenia: "+contrasenia);
			System.err.println(e);
			manejaExcepcion(e);

		} finally {
			getSession().close();
		}
		return user;	}

	
}

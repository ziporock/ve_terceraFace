package ve.util;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import ve.modelo.Claustro;
import ve.modelo.Estado;
import ve.modelo.Lista;
import ve.modelo.Rol;
import ve.modelo.Terminal;
import ve.modelo.Usuario;
import ve.modelo.Votante;
import ve.modelo.Voto;

public class HibernateSessionManager {

	private static SessionFactory sessionFactory = buildSessionFactory();
	private static ServiceRegistry serviceRegistry;

	static Logger logger = Logger.getLogger(HibernateSessionManager.class);

	private static SessionFactory buildSessionFactory() {
		try {

			String PATH_HIBERNATE = "/hibernate.cfg.xml";

			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Votante.class)
					.addAnnotatedClass(Lista.class)
					.addAnnotatedClass(Votante.class)
					.addAnnotatedClass(Claustro.class)
					.addAnnotatedClass(Estado.class)
					.addAnnotatedClass(Voto.class)
					.addAnnotatedClass(Terminal.class)
					.addAnnotatedClass(Rol.class)
					.addAnnotatedClass(Usuario.class).configure(PATH_HIBERNATE);

			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			return sessionFactory;

		} catch (Throwable ex) {
			logger.error("error al crear la sessionFactory." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

}

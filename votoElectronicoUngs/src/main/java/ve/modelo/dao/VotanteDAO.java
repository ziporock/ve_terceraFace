package ve.modelo.dao;

import org.hibernate.HibernateException;

import ve.modelo.Votante;

@SuppressWarnings("rawtypes")
public interface VotanteDAO extends EntidadDAO {

	Votante getByNroDocumento(Integer nroDocumento) throws HibernateException;
}

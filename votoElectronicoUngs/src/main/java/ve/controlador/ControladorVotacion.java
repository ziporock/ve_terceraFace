package ve.controlador;

import ve.modelo.Claustro;
import ve.modelo.Estado;
import ve.modelo.Rol;
import ve.modelo.Usuario;
import ve.modelo.Votante;
import ve.modelo.dao.EntidadDAO;
import ve.modelo.dao.EstadoDAO;
import ve.modelo.dao.VotanteDAO;
import ve.modelo.dao.impl.RolDAOImpl;
import ve.modelo.dao.impl.UsuarioDAOImpl;
import ve.util.CONSTANTE;

public class ControladorVotacion {
	private ValidadorVotante validador;
	private EstadoDAO estadoDAO;
	private VotanteDAO votanteDAO;
	private EntidadDAO<Claustro> claustroDao;

	public void habilitarVotante(Votante votante) throws Exception {

		if (validador.estadoValido(votante)) {

		} else {
			throw new Exception(CONSTANTE.ERROR_PERSONA_YA_VOTO);
		}

	}

	// public long votarListas(Set<Lista> listas) {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	//
	// public ResultadoVotacion getResultados() {
	// // TODO Auto-generated method stub
	// return null;
	// }
	
	

	@SuppressWarnings("unchecked")
	public void inicializar() {

		
		Claustro claustro = new Claustro();
		claustro.setDescripcion("claustro desc");
		claustro.setNombre("claustro nom");

		claustroDao.guardar(claustro);

		Votante votante = new Votante();
		votante.setApellido("Gaston");
		votante.setNombre("Alles");
		votante.setNroDocumento(1);

		cargarEstados();

		votante.setEstado((Estado) estadoDAO.getById(Estado.class, 1L));

		votante.setClaustro(claustro);

		votanteDAO.guardar(votante);

		Votante votante1 = new Votante();
		votante1.setApellido("guido");
		votante1.setNombre("dorrego");
		votante1.setNroDocumento(2);

		votante1.setClaustro(claustro);

		votante1.setEstado((Estado) estadoDAO.getById(Estado.class, 1L));

		votanteDAO.guardar(votante1);

		Votante votante2 = new Votante();
		votante2.setApellido("pepe");
		votante2.setNombre("pepe");
		votante2.setNroDocumento(3);

		votante2.setClaustro(claustro);

		votante2.setEstado((Estado) estadoDAO.getById(Estado.class, 3L));

		votanteDAO.guardar(votante2);

	}

	@SuppressWarnings("unchecked")
	private void cargarEstados() {

		Estado estadoInicial = new Estado();
		estadoInicial.setCodigo(CONSTANTE.ESTADO_INICIAL);
		estadoInicial.setDescripcion("inicial por defecto");

		Estado votando = new Estado();
		votando.setCodigo(CONSTANTE.ESTADO_PROCESO);
		votando.setDescripcion("votando");

		Estado votoExitoso = new Estado();
		votoExitoso.setCodigo(CONSTANTE.ESTADO_FINALIZADO);
		votoExitoso.setDescripcion("voto exitoso");

		estadoDAO.guardar(estadoInicial);
		estadoDAO.guardar(votando);
		estadoDAO.guardar(votoExitoso);

	}

	@SuppressWarnings("unchecked")
	public void cerrarVoto(Votante votante) {
		votante.setEstado((Estado) estadoDAO.getById(Estado.class, 3L));

		votanteDAO.actualizar(votante);
	}

	public ValidadorVotante getValidador() {
		return validador;
	}

	public void setValidador(ValidadorVotante validador) {
		this.validador = validador;
	}

	public EstadoDAO getEstadoDAO() {
		return estadoDAO;
	}

	public void setEstadoDAO(EstadoDAO estadoDAO) {
		this.estadoDAO = estadoDAO;
	}

	public VotanteDAO getVotanteDAO() {
		return votanteDAO;
	}

	public void setVotanteDAO(VotanteDAO votanteDAO) {
		this.votanteDAO = votanteDAO;
	}

	public EntidadDAO<Claustro> getClaustroDao() {
		return claustroDao;
	}

	public void setClaustroDao(EntidadDAO<Claustro> claustroDao) {
		this.claustroDao = claustroDao;
	}

	public Votante getVotanteByNroDocumento(Integer nroDocumento) {
		return this.votanteDAO.getByNroDocumento(nroDocumento);
	}

}

package ve.controlador;

import org.junit.Before;
import org.junit.Test;

import ve.controlador.ValidadorVotante;
import ve.modelo.Estado;
import ve.modelo.Votante;
import ve.modelo.Voto;
import ve.modelo.dao.impl.ValidadorVotanteMock;
import ve.util.CONSTANTE;

public class ValidadorVotanteTest {

	private ValidadorVotanteMock validadorVotante;

	@Before
	public void preparar() {
		validadorVotante = new ValidadorVotanteMock();
	
	}

	@Test
	public void obtenerVotanteValidoTest() throws Exception {
		validadorVotante.obtenerVotante("2");

	}

	@Test
	public void estadoValidoTest() throws Exception {
		Votante votante=new Votante();
		Estado estado=new Estado();
		estado.setCodigo(CONSTANTE.ESTADO_INICIAL);
		votante.setEstado(estado);
		validadorVotante.estadoValido(votante);

	}

	@SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
	public void testNullPointer() {

		ValidadorVotante validadorVotante = null;
		validadorVotante.getVotanteDAO();

	}
	
}

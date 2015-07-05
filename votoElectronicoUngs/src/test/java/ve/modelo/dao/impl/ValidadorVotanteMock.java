package ve.modelo.dao.impl;

import ve.controlador.ValidadorVotante;
import ve.modelo.Votante;

public class ValidadorVotanteMock extends ValidadorVotante {

	public ValidadorVotanteMock() {
		super.setVotanteDAO(new VotanteDAOImplMock());
	}

	public Votante obtenerVotante(String id) {
		if (id.equals("1")) {
			return super.obtenerVotante("1");
		} else
			return null;

	}

	public boolean estadoValido(Votante votante) {
		return super.estadoValido(votante);
	}
}

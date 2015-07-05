package ve.modelo;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import ve.modelo.Lista;
import ve.modelo.ResultadoVotacion;

public class ResultadoVotacionTest {

	private static final Map<Lista, Double> RESULTADOS = new HashMap<Lista, Double>() ;
	private static final long ID_1 = 100l;
	private static final String DESCRIPCION_1 = "PARTIDO OBRERO";
	private static final String NOMBRE_1 = "PO";
	private static final long ID_2 = 101l;
	private static final String DESCRIPCION_2 = "Pan y Rosas";
	private static final String NOMBRE_2 = "PA";

	private Lista lista1;
	private Lista lista2;
	
	@Before
	public void preparar() {
		lista1 = new Lista();
		lista1.setId(ID_1);
		lista1.setNombre(NOMBRE_1);
		lista1.setDescripcion(DESCRIPCION_1);
		lista2 = new Lista();
		lista2.setId(ID_2);
		lista2.setNombre(NOMBRE_2);
		lista2.setDescripcion(DESCRIPCION_2);
		RESULTADOS.put(lista1, 60.0);
		RESULTADOS.put(lista2, 40.0);
	}

	@Test
	public void testGetterResultados() {

		Assert.assertNotNull(RESULTADOS);
		Assert.assertEquals(RESULTADOS.get(lista1), 60.0);
	
	}
	
	@Test
	public void resultadoVotacionToString(){
		Assert.assertNotNull( RESULTADOS.toString());
	}

	@SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
	public void testNullPointer() {

		ResultadoVotacion resultadoVotacion = null;
		resultadoVotacion.getResultados().equals(new HashMap<Lista, Double>());

	}
	
	@Test
	public void toStringTest(){
		ResultadoVotacion resultadoVotacion=new ResultadoVotacion();
		resultadoVotacion.toString();
	}
}
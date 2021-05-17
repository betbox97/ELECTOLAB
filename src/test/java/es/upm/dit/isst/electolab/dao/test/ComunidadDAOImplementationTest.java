package es.upm.dit.isst.electolab.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import es.upm.dit.isst.electolab.dao.ComunidadDAO;
import es.upm.dit.isst.electolab.dao.ComunidadDAOImplementation;
import es.upm.dit.isst.electolab.model.Comunidad;

class ComunidadDAOImplementationTest {

   ComunidadDAO comunidad = ComunidadDAOImplementation.getInstance();
	@Test
	void testCreate() {
	Comunidad c= new Comunidad ();
	c.setEscenarioComplejoID(222444);
	c.setNumeroSimulacionesComunidad(5);
	c.setEscenarioSimpleID(333);
	c.setComunidadID(444);
	
		ComunidadDAOImplementation.getInstance().create(c);
		Comunidad c2 = ComunidadDAOImplementation.getInstance().read(444);
		assertEquals(c, c2);
	}
	

	@Test
	void testReadAll() {
		assertFalse(!(comunidad.readAll().isEmpty()));
	}
}

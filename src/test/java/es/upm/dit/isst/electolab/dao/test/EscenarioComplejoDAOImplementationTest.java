package es.upm.dit.isst.electolab.dao.test;



import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.electolab.dao.EscenarioComplejoDAO;
import es.upm.dit.isst.electolab.dao.EscenarioComplejoDAOImplementation;
import es.upm.dit.isst.electolab.model.*;


class EscenarioComplejoDAOImplementationTest {

	private EscenarioComplejo escenario, escenarioDAO;
	private String partidos [] = {"PSOE","PP","VOX","UP"};
	private  EscenarioComplejoDAO es;
	
	@BeforeEach
	void setUp() throws Exception {
		
        es = EscenarioComplejoDAOImplementation.getInstance();
		escenario = new EscenarioComplejo();
		int votos []= {1000,1000,500,500};
		escenario.setPartidosPoliticos(partidos);
		escenario.setVotos(votos);
		escenario.setFecha(new Date());
		escenario.setAuthor("g07");
		escenario.setEscenarioComplejoID(1122);
	
	}
	

	@AfterEach
	void tearDown() throws Exception {
		EscenarioComplejoDAOImplementation.getInstance().delete(escenario);
		EscenarioComplejo escenarioDAO_deleted = EscenarioComplejoDAOImplementation.getInstance().read(1122);
		assertNull(escenarioDAO_deleted);
	}

	
	
	@Test
	void testUpdate() {
		String partidos_nuevos [] = {"ERC", "Ciudadanos","MASMADRID"};
		escenario.setPartidosPoliticos(partidos_nuevos);
		escenarioDAO = EscenarioComplejoDAOImplementation.getInstance().update(escenario);
		assertEquals(partidos_nuevos, escenarioDAO.getPartidosPoliticos());
		

	}
	
	@Test
	void testRead() {
		EscenarioComplejoDAOImplementation.getInstance().create(escenario);
		EscenarioComplejo es = EscenarioComplejoDAOImplementation.getInstance().read(1122);
		assertEquals(escenario, es);
	}
	
	@Test
	void testReadAll() {
		EscenarioComplejoDAOImplementation.getInstance().create(escenario);
		assertTrue(!(es.readAll().isEmpty()));

	}
}

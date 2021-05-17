package es.upm.dit.isst.electolab.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.electolab.dao.EscenarioSimpleDAOImplementation;
import es.upm.dit.isst.electolab.model.EscenarioSimple;

class EscenarioSimpleDAOImplementationTest {

private EscenarioSimple escenario, escenarioDAO;
	
	@BeforeEach
	void setUp() throws Exception {
		escenario = new EscenarioSimple();
		
		String partidos [] = {"PSOE", "PP","VOX","UP"};
		int votos []= {1000,1000,500,500};
		escenario.setPartidosPoliticos(partidos);
		escenario.setVotos(votos);
		escenario.setFecha(new Date());
		escenario.setAuthor("g07");
		escenario.setEscenarioSimpleID(1122);
		
		
	}
	

	@AfterEach
	void tearDown() throws Exception {
		EscenarioSimpleDAOImplementation.getInstance().delete(escenarioDAO);
		EscenarioSimple escenarioDAO_deleted = EscenarioSimpleDAOImplementation.getInstance().read(1122);
		assertNull(escenarioDAO_deleted);
	}

	
	@Test
	void testEscenarioSimple() {

		
		EscenarioSimpleDAOImplementation.getInstance().create(escenario);
		escenarioDAO = EscenarioSimpleDAOImplementation.getInstance().read(1122);
		assertEquals(escenario, escenarioDAO);
		assertEquals(escenario.getFecha(), escenarioDAO.getFecha());
		
		

	}

	@Test
	void testUpdate() {
		String partidos_nuevos [] = {"ERC", "Ciudadanos","MASMADRID"};
		escenario.setPartidosPoliticos(partidos_nuevos);
		escenarioDAO = EscenarioSimpleDAOImplementation.getInstance().update(escenario);
		assertEquals(partidos_nuevos, escenarioDAO.getPartidosPoliticos());
		

	}

}

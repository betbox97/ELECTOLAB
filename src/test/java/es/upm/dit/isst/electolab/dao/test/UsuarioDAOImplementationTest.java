package es.upm.dit.isst.electolab.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import es.upm.dit.isst.electolab.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.electolab.model.Usuario;

class UsuarioDAOImplementationTest {

Usuario u = new Usuario();

@Test 
void testCreate () {
	u.setCommunity("labsinfronteras");
	u.setEmail("user@upm.es");
	u.setPassword("password");
	u.setNumeroSimulacionesUsuario(3);
	u.setStatus(3);
	
	UsuarioDAOImplementation.getInstance().create(u);
	Usuario u2 = UsuarioDAOImplementation.getInstance().read("user@upm.es");
	
	
	assertEquals(u, u2);
}


}

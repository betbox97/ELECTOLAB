package es.upm.dit.isst.electolab.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.electolab.model.Usuario;
import es.upm.dit.isst.electolab.model.Comunidad;
import es.upm.dit.isst.electolab.servlets.URLHelper_Usuario;

/**
 * Servlet implementation class LimpiarEscenarioServlet
 */
@WebServlet("/LimpiarEscenarioServlet")
public class LimpiarEscenarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String comunidadID = req.getParameter("comunidadID");
		Client client = ClientBuilder.newClient(new ClientConfig());
		Comunidad comunidad = null;
		try {
			comunidad = client.target(URLHelper_Comunidad.getURL() + "/" + comunidadID)
					  .request().accept(MediaType.APPLICATION_JSON).get(Comunidad.class);
		} catch(Exception e) {}
		if (comunidad != null) {  
			comunidad.setNumeroSimulacionesComunidad(0);
			comunidad.setGrafica(null);
			client.target(URLHelper_Comunidad.getURL() + "/" + comunidad.getComunidadID()).request()
            			.post(Entity.entity(comunidad, MediaType.APPLICATION_JSON), Response.class);
			    req.setAttribute("comunidad", comunidad);
		}

        
        /*List<TFG> tfgs = client.target(URLHelper.getURL())
        	.request().accept(MediaType.APPLICATION_JSON)
        	.get(new GenericType<List<TFG>>() {});
        request.setAttribute("tfgs", tfgs);
        
        getServletContext().getRequestDispatcher("/Usuario.jsp").forward(req,resp);
        return;
		*/  
		getServletContext().getRequestDispatcher("/Comunidad.jsp").forward(req,resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}*/

}

package es.upm.dit.isst.electolab.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.electolab.model.Usuario;

/**
 * Servlet implementation class EscenarioComplejoServlet
 */
@WebServlet("/EscenarioComplejoServlet")
public class EscenarioComplejoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String email = req.getParameter("email");
        Client client = ClientBuilder.newClient(new ClientConfig());

		Usuario usuario = null;
		try {
			usuario = client.target(URLHelper_Usuario.getURL() + "/" + email)
					  .request().accept(MediaType.APPLICATION_JSON).get(Usuario.class);
		} catch(Exception e) {}
		if (usuario != null) { 
			client.target(URLHelper_Usuario.getURL() + "/" + usuario.getEmail()).request()
            			.post(Entity.entity(usuario, MediaType.APPLICATION_JSON), Response.class);
			    req.setAttribute("usuario", usuario);
		} 	
		getServletContext().getRequestDispatcher("/EscenarioComplejo.jsp").forward(req,resp);
    }             
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

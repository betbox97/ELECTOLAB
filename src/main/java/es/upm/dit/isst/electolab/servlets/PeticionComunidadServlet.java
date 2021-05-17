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
 * Servlet implementation class PeticionComunidadServlet
 */
@WebServlet("/PeticionComunidadServlet")
public class PeticionComunidadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String solicitud_comunidad = req.getParameter("comunidad");
		Client client = ClientBuilder.newClient(new ClientConfig());
		Usuario usuario = null;
		try {
			usuario = client.target(URLHelper_Usuario.getURL() + "/" + email)
					  .request().accept(MediaType.APPLICATION_JSON).get(Usuario.class);
		} catch(Exception e) {}
		if (usuario != null) {  
			usuario.setStatus(usuario.getStatus()+1);
			usuario.setCommunity(solicitud_comunidad);
			client.target(URLHelper_Usuario.getURL() + "/" + usuario.getEmail()).request()
            			.post(Entity.entity(usuario, MediaType.APPLICATION_JSON), Response.class);
			    req.setAttribute("usuario", usuario);
		}

        
        /*List<TFG> tfgs = client.target(URLHelper.getURL())
        	.request().accept(MediaType.APPLICATION_JSON)
        	.get(new GenericType<List<TFG>>() {});
        request.setAttribute("tfgs", tfgs);
        
        getServletContext().getRequestDispatcher("/Usuario.jsp").forward(req,resp);
        return;
		*/  
		getServletContext().getRequestDispatcher("/ResultadoPeticion.jsp").forward(req,resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}*/

}

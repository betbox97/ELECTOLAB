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

import es.upm.dit.isst.electolab.model.Comunidad;
import es.upm.dit.isst.electolab.model.Usuario;

/**
 * Servlet implementation class ComunidadServlet
 */
@WebServlet("/ComunidadServlet")
public class ComunidadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String comunidadID = req.getParameter("IDComunidad");
        Client client = ClientBuilder.newClient(new ClientConfig());
     	
        req.getSession().setAttribute("user", comunidadID);
        List<Comunidad> comunidades  = client.target(URLHelper_Usuario.getURL() + "/user/" + comunidadID)
                    .request().accept(MediaType.APPLICATION_JSON)
                    .get(new GenericType<List<Comunidad>>() {});
        //req.setAttribute("comunidades", comunidades);//quit?
         
        //get user parameters
        Comunidad comunidad = null;
     	try { comunidad = client.target(URLHelper_Comunidad.getURL() + "/" + comunidadID)
                 .request().accept(MediaType.APPLICATION_JSON).get(Comunidad.class);
     	}catch (Exception e) {
     	}
     	if ( null != comunidad ) {
         req.getSession().setAttribute("comunidad", comunidad);
     	}
        getServletContext().getRequestDispatcher("/Comunidad.jsp").forward(req,resp);
        return;
     	
     	


     	    
	} 	
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

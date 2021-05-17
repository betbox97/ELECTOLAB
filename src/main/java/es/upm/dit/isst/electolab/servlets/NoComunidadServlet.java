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
 * Servlet implementation class FormLoginServlet
 */
@WebServlet("/NoComunidadServlet")
public class NoComunidadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                       throws ServletException, IOException {
        String email = req.getParameter("email");
        Client client = ClientBuilder.newClient(new ClientConfig());

        
             
        req.getSession().setAttribute("comunidad", email);
        List<Comunidad> comunidades = client.target(URLHelper_Comunidad.getURL())
        	.request().accept(MediaType.APPLICATION_JSON)
        	.get(new GenericType<List<Comunidad>>() {});
        req.setAttribute("comunidades", comunidades);
     	getServletContext().getRequestDispatcher("/NoComunidad.jsp").forward(req,resp);
     	
     	//get user parameters
        /*Usuario usuario = null;
     	try { usuario = client.target(URLHelper_Usuario.getURL() + "/" + email)
                 .request().accept(MediaType.APPLICATION_JSON).get(Usuario.class);
     	}catch (Exception e) {
     	}
     	if ( null != usuario ) {
         req.getSession().setAttribute("usuario", usuario);
     	}
         getServletContext().getRequestDispatcher("/NoComunidad.jsp").forward(req,resp);
         return;
    */}
                    
        // autenticacion3
/*        TFG tfg = null;
        try { tfg = client.target(URLHelper.getURL() + "/" + email)
                        .request().accept(MediaType.APPLICATION_JSON).get(TFG.class);
        }catch (Exception e) {
        }
        if ( null != tfg ) {
                req.getSession().setAttribute("tfg", tfg);
                getServletContext().getRequestDispatcher("/TFG.jsp").forward(req,resp);
                return;
        }
*/
    
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

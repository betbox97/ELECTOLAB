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
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.electolab.model.Usuario;

/**
 * Servlet implementation class FormLoginServlet
 */
@WebServlet("/FormLoginServlet")
public class FormLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final String ADMIN_EMAIL = "root";
    private final String ADMIN_PASSWORD = "root";     
       
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                       throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Client client = ClientBuilder.newClient(new ClientConfig());

        // autenticacion1 = Admin
        if( ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password) ) {        
             req.getSession().setAttribute("admin", true);
             List<Usuario> usuarios  = client.target(URLHelper_Usuario.getURL())
                    .request().accept(MediaType.APPLICATION_JSON)
                    .get(new GenericType<List<Usuario>>() {});
             req.setAttribute("usuarios", usuarios);
             getServletContext().getRequestDispatcher("/Admin.jsp").forward(req,resp);
            return;
        }
        // autenticacion2 = Usuario
        if ( email.indexOf("@electolab.es") > -1) {	//????
        	
            req.getSession().setAttribute("user", email);
            List<Usuario> usuarios  = client.target(URLHelper_Usuario.getURL() + "/user/" + email)
                        .request().accept(MediaType.APPLICATION_JSON)
                        .get(new GenericType<List<Usuario>>() {});
            req.setAttribute("usuarios", usuarios);//quit?
             
            //get user parameters
            Usuario usuario = null;
         	try { usuario = client.target(URLHelper_Usuario.getURL() + "/" + email)
                     .request().accept(MediaType.APPLICATION_JSON).get(Usuario.class);
         	}catch (Exception e) {
         	}
         	if ( null != usuario ) {
             req.getSession().setAttribute("usuario", usuario);
         	}
            getServletContext().getRequestDispatcher("/Usuario.jsp").forward(req,resp);
            return;
        }            
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
*/        getServletContext().getRequestDispatcher("/index.html").forward(req,resp);
    }
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

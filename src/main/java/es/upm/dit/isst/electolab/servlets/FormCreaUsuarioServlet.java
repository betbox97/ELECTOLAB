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

@WebServlet("/FormCreaUsuarioServlet")
public class FormCreaUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String userNameEmail = req.getParameter("email");
	        if (userNameEmail.indexOf("electolab.es") > 0) {
	                Usuario usuario = new Usuario();
	                usuario.setEmail(req.getParameter("email"));
	                usuario.setPassword(req.getParameter("password"));
	                usuario.setNumeroSimulacionesUsuario(0);
	                //usuario.setInCommunity(false);	//quit?
	                usuario.setUserName(req.getParameter("userName"));
	                usuario.setCommunity(req.getParameter("community"));
	                usuario.setComunidadID(0);
	                usuario.setStatus(0);
	                Client client = ClientBuilder.newClient(new ClientConfig());
	               Response r = client.target(URLHelper_Usuario.getURL()).request()
	                        .post(Entity.entity(usuario, MediaType.APPLICATION_JSON)
	                       , Response.class);
	                if (r.getStatus() == 200) {
	                        req.getSession().setAttribute("usuario", usuario);
	                        getServletContext().getRequestDispatcher("/Usuario.jsp").forward(req, resp);
	                        return;
	                }
	        }        
	        getServletContext().getRequestDispatcher("/index.html").forward(req, resp);
	}
}

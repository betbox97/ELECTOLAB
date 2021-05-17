package es.upm.dit.isst.electolab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.electolab.model.Comunidad;

/**
 * Servlet implementation class FormBajaEscenarioServlet
 */
@WebServlet("/FormBajaEscenarioServlet")
public class FormBajaEscenarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	  // autorizacion: any
	  String comunidadID = req.getParameter("comunidadID");
	  Client client = ClientBuilder.newClient(new ClientConfig());
	  Comunidad comunidad = null;
	  try {   comunidad=client.target(URLHelper_Comunidad.getURL()+"/"+ comunidadID)
	      .request().accept(MediaType.APPLICATION_JSON).get(Comunidad.class);
	  }catch(Exception e) {}
	  if ((comunidad != null)  && (comunidad.getGrafica() != null)){
	    resp.setContentType("application/png");//application/pdf
	    resp.setHeader("Content-Disposition"
	          , String.format("attachment; filename=\"%s\"", "escenario.png"));//escenario.pdf
	    resp.setContentLength(comunidad.getGrafica().length);
	    resp.getOutputStream().write(comunidad.getGrafica());
	  }
	}
	
}
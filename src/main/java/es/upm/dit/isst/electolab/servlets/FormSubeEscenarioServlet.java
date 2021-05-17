package es.upm.dit.isst.electolab.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.electolab.model.Comunidad;

/**
 * Servlet implementation class FormSubeEscenarioServlet
 */
@WebServlet("/FormSubeEscenarioServlet")
@MultipartConfig
public class FormSubeEscenarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	               throws ServletException, IOException {

	    // autorizacion, comprobar
	    String comunidadID = req.getParameter("comunidadID");
	    Client client = ClientBuilder.newClient(new ClientConfig());
	    Comunidad comunidad = null;
	    try {
	         comunidad = client.target(URLHelper_Comunidad.getURL() + "/" + comunidadID)
	           .request().accept(MediaType.APPLICATION_JSON).get(Comunidad.class);
	    } catch(Exception e) {}

	    // autorizacion
	    if (comunidad != null) {
	         Part filePart = req.getPart("file");
	         InputStream fileContent = filePart.getInputStream();
	         ByteArrayOutputStream output = new ByteArrayOutputStream();
	         byte[] buffer = new byte[1024];
	         for (int length = 0; (length = fileContent.read(buffer)) > 0;)
	                 output.write(buffer, 0, length);
	         comunidad.setGrafica(output.toByteArray());
	         comunidad.setNumeroSimulacionesComunidad(1);
	         client.target(URLHelper_Comunidad.getURL() + "/" + comunidad.getComunidadID()).request()
	                 .post(Entity.entity(comunidad, MediaType.APPLICATION_JSON), Response.class);
	         req.setAttribute("comunidad", comunidad);
	     }
	    getServletContext().getRequestDispatcher("/Comunidad.jsp").forward(req,resp);

	  }

}

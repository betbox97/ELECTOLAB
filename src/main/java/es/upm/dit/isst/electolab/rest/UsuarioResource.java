package es.upm.dit.isst.electolab.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.upm.dit.isst.electolab.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.electolab.model.Usuario;

@Path("/Users")
public class UsuarioResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> readAll () {
	        return UsuarioDAOImplementation.getInstance().readAll();
	}
	
	@GET
	@Path("user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> readAll (@PathParam("id") String id) {
	        return UsuarioDAOImplementation.getInstance().readAll(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Usuario tnew) throws URISyntaxException {
	    Usuario t = UsuarioDAOImplementation.getInstance().create(tnew);
	    if (t != null) {
	            URI uri = new URI("/ElectoLab-SERVICE/rest/Users/" + t.getEmail());
	            return Response.created(uri).build();
	    }
	    return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response read(@PathParam("id") String id) {
        Usuario t = UsuarioDAOImplementation.getInstance().read(id);
        if (t == null)
          return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(t, MediaType.APPLICATION_JSON).build();
    }        

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") String id, Usuario t) {
            System.out.println("Update request for" + id + " " + t.toString());
        Usuario told = UsuarioDAOImplementation.getInstance().read(id);
        if ((told == null) || (! told.getEmail().contentEquals(t.getEmail())))
          return Response.notModified().build();
        UsuarioDAOImplementation.getInstance().update(t);
        return Response.ok().build();                
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String  id) {
        Usuario rold = UsuarioDAOImplementation.getInstance().read(id);
        if (rold == null)
            return Response.notModified().build();
        UsuarioDAOImplementation.getInstance().delete(rold);
        return Response.ok().build();
    }
	
}

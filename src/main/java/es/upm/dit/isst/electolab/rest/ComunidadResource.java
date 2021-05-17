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

import es.upm.dit.isst.electolab.dao.ComunidadDAOImplementation;
import es.upm.dit.isst.electolab.model.Comunidad;

@Path("/Community")
public class ComunidadResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comunidad> readAll () {
	        return ComunidadDAOImplementation.getInstance().readAll();
	}
	
	@GET
	@Path("user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comunidad> readAll (@PathParam("id") String id) {
	        return ComunidadDAOImplementation.getInstance().readAll(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Comunidad tnew) throws URISyntaxException {
	    Comunidad t = ComunidadDAOImplementation.getInstance().create(tnew);
	    if (t != null) {
	            URI uri = new URI("/ElectoLab-SERVICE/rest/Community/" + t.getComunidadID());
	            return Response.created(uri).build();
	    }
	    return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response read(@PathParam("id") int id) {
        Comunidad t = ComunidadDAOImplementation.getInstance().read(id);
        if (t == null)
          return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(t, MediaType.APPLICATION_JSON).build();
    }        

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, Comunidad t) {
            System.out.println("Update request for" + id + " " + t.toString());
        Comunidad told = ComunidadDAOImplementation.getInstance().read(id);
        if ((told == null) || (!(told.getComunidadID()==(t.getComunidadID()))))
          return Response.notModified().build();
        ComunidadDAOImplementation.getInstance().update(t);
        return Response.ok().build();                
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int  id) {
        Comunidad rold = ComunidadDAOImplementation.getInstance().read(id);
        if (rold == null)
            return Response.notModified().build();
        ComunidadDAOImplementation.getInstance().delete(rold);
        return Response.ok().build();
    }
	
}

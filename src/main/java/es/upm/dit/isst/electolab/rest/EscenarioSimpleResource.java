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

import es.upm.dit.isst.electolab.dao.EscenarioSimpleDAOImplementation;
import es.upm.dit.isst.electolab.model.EscenarioSimple;

@Path("/SimpleScenario")
public class EscenarioSimpleResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EscenarioSimple> readAll () {
	        return EscenarioSimpleDAOImplementation.getInstance().readAll();
	}
	
	@GET
	@Path("user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EscenarioSimple> readAll (@PathParam("id") String id) {
	        return EscenarioSimpleDAOImplementation.getInstance().readAll(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(EscenarioSimple tnew) throws URISyntaxException {
	    EscenarioSimple t = EscenarioSimpleDAOImplementation.getInstance().create(tnew);
	    if (t != null) {
	            URI uri = new URI("/ElectoLab-SERVICE/rest/SimpleScenario/" + t.getEscenarioSimpleID());
	            return Response.created(uri).build();
	    }
	    return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response read(@PathParam("id") int id) {
        EscenarioSimple t = EscenarioSimpleDAOImplementation.getInstance().read(id);
        if (t == null)
          return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(t, MediaType.APPLICATION_JSON).build();
    }        

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, EscenarioSimple t) {
            System.out.println("Update request for" + id + " " + t.toString());
        EscenarioSimple told = EscenarioSimpleDAOImplementation.getInstance().read(id);
        if ((told == null) || (!(told.getEscenarioSimpleID()==(t.getEscenarioSimpleID()))))
          return Response.notModified().build();
        EscenarioSimpleDAOImplementation.getInstance().update(t);
        return Response.ok().build();                
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int  id) {
        EscenarioSimple rold = EscenarioSimpleDAOImplementation.getInstance().read(id);
        if (rold == null)
            return Response.notModified().build();
        EscenarioSimpleDAOImplementation.getInstance().delete(rold);
        return Response.ok().build();
    }
	
}

package ws_crud.correction.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import ws_crud.correction.Spectacle;
import ws_crud.correction.dao.SpectaclesDAO;
import java.util.List;

@Path("/spectacles")
public class SpectaclesAPI {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Spectacle> getAll(){
        return SpectaclesDAO.getSingleton().getSpectacles();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Spectacle spectacle) {
        SpectaclesDAO.getSingleton().addSpecacle(spectacle);
        return Response.status(Response.Status.CREATED).entity(spectacle).build();
    }
}

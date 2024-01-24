package show_crud.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import show_crud.services.TicketsDAO;
import show_crud.models.Show;

import java.util.Collections;
import java.util.List;

@Path("/shows")
public class TicketsAPI {
    @GET
    @Produces (MediaType.APPLICATION_JSON)
    public List<Show> getAllShows(){
        try {
            return TicketsDAO.getSingleton().getList();
        } catch (Exception error) {
            error.printStackTrace();
            return Collections.emptyList();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addShow(Show newShow){
        // System.out.println(newShow);
        try {
            TicketsDAO.getSingleton().addShow(newShow);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(newShow).build();
        } catch (Exception error){
            error.printStackTrace();
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erreur lors de l'ajout du spectacle.").build();
        }
    }

    /*
    @GET
    Path("/{showId}/reservations")
    @Produces (MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Show> getShowsValidate(@PathParam("showId") Integer showId){
        return ReservationsDAO.getSingleton().getById(showId);
    }*/
}

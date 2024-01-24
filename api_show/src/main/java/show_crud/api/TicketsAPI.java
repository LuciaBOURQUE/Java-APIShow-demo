package show_crud.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import show_crud.dao.TicketsDAO;
import show_crud.models.Show;

import java.util.List;

@Path("/shows")
public class TicketsAPI {
    // On aurait très bien pu mettre notre Singleton dans notre Class ZooTiger
    // On récupère ici la Class Tickets pour la portée de variable
    private static TicketsDAO tickets = new TicketsDAO();

    @GET
    @Produces (MediaType.APPLICATION_JSON)
    public List<Show> getShow(){
        return tickets.getList();
    }

    // On retourne Response avec un @Produces en plus pour définir le format souhaité
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addShow(Show newShow){
        System.out.println(newShow);
        tickets.addShow(newShow);
        return Response
                .status(Response.Status.CREATED)
                .entity(newShow).build();
    }
}

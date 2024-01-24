package ws_crud;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/shows")
public class TicketsAPI {
    // On aurait très bien pu mettre notre Singleton dans notre Class ZooTiger
    // On récupère ici la Class Tickets pour la portée de variable
    private static TicketsOffice tickets = new TicketsOffice();

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

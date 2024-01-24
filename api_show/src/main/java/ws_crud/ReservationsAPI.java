package ws_crud;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/reservations")
public class ReservationsAPI {
    // On récupère ici la Class Réservations pour la portée de variable
    private static ReservationsOffice reservations = new ReservationsOffice();
    private static TicketsOffice tickets = new TicketsOffice();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getReservation() {
        return reservations.getList();
    }

    @GET
    @Path("/{id}/validate")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReservationValidate(@PathParam("id") Integer id, Person person) {
        Show show = tickets.getShow(id);
        if (id.equals(show) && reservations.isReserved(person))
            reservations.getList();
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addReservation(Person newPerson) {
        //newPerson.getChoiceShow() == null &&
        if (newPerson.getPseudo().isBlank()) {
            // Retourner BAD REQUEST 400
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Le champs est vide").build();
        }

        // Retourner 201 OK
        reservations.addReservation(newPerson);
        return Response
                .status(Response.Status.CREATED)
                .entity(newPerson).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteReservation(@PathParam("id") int id) {
        reservations.deleteReservation(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateReservation(@PathParam("id") Integer id, Person person) {
        if (id.equals(person.getId())) {
            // Retourner 400 BAD REQUEST
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("ID différent").build();
        } else {
            // Retourner 404 NOT FOUND
            Person p = reservations.getReservation(id);
            if (p == null) {
                return Response
                        .status(Response.Status.NOT_FOUND)
                        .entity("ID inexistant").build();
            }
        }

        // Retourner OK
        reservations.updateReservation(id, person);
        return Response.ok().build();
    }
}

/*
{
    "pseudo": "bibi",
    "choiceShow": 1,
    "reserved" : false
}

{
    "pseudo": "arthur_2548B",
    "choiceShow": 1,
    "reserved": true
}
 */
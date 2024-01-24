package show_crud.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import show_crud.services.ReservationsDAO;
import show_crud.services.TicketsDAO;
import show_crud.models.Reservation;
import show_crud.models.Show;

import java.util.List;

@Path("/reservations")
public class ReservationsAPI {
    // On récupère ici la Class Réservations pour la portée de variable
    private static ReservationsDAO reservations = new ReservationsDAO();
    private static TicketsDAO tickets = new TicketsDAO();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reservation> getReservation() {
        return reservations.getList();
    }

    @GET
    @Path("/{id}/validate")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReservationValidate(@PathParam("id") Integer id, Reservation reservation) {
        Show show = tickets.getShow(id);
        if (id.equals(show) && reservations.isReserved(reservation))
            reservations.getList();
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addReservation(Reservation newReservation) {
        //newPerson.getChoiceShow() == null &&
        if (newReservation.getPseudo().isBlank()) {
            // Retourner BAD REQUEST 400
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Le champs est vide").build();
        }

        // Retourner 201 OK
        reservations.addReservation(newReservation);
        return Response
                .status(Response.Status.CREATED)
                .entity(newReservation).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteReservation(@PathParam("id") int id) {
        reservations.deleteReservation(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateReservation(@PathParam("id") Integer id, Reservation reservation) {
        if (id.equals(reservation.getId())) {
            // Retourner 400 BAD REQUEST
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("ID différent").build();
        } else {
            // Retourner 404 NOT FOUND
            Reservation p = reservations.getReservation(id);
            if (p == null) {
                return Response
                        .status(Response.Status.NOT_FOUND)
                        .entity("ID inexistant").build();
            }
        }

        // Retourner OK
        reservations.updateReservation(id, reservation);
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
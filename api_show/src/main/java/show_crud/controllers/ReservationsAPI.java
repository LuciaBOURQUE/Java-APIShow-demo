package show_crud.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import show_crud.services.ReservationsDAO;
import show_crud.models.Reservation;
import show_crud.models.Show;
import show_crud.services.TicketsDAO;

import java.util.Collections;
import java.util.List;

@Path("/reservations")
public class ReservationsAPI {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reservation> getAllReservations() {
        try {
            return ReservationsDAO.getSingleton().getList();
        }catch (Exception error){
            error.printStackTrace();
            return Collections.emptyList();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addReservation(Reservation newReservation) {
        Show show = TicketsDAO.getSingleton().getById(newReservation.getReserveShowId());

        if (show == null){
            return Response
                    .status(Response.Status.NOT_FOUND) // 404
                    .entity("ID de spectacle non trouvé : " + newReservation.getReserveShowId())
                    .build();
        } else {
            if (newReservation.getPseudo().isBlank()) {
                return Response
                        .status(Response.Status.BAD_REQUEST) // 400
                        .entity("Le champ pseudo ou l'ID de spectacle est vide ou nul").build();
            }
        }

        // Retourner OK 201
        ReservationsDAO.getSingleton().addReservation(newReservation);
        return Response
                .status(Response.Status.CREATED) // 201
                .entity(newReservation).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteReservation(@PathParam("id") Integer id) {
        ReservationsDAO.getSingleton().deleteReservation(id);
        return Response
                .noContent().build(); // send a 204 Status : No Content
    }

    @PUT
    @Path("/{id}")
    public Response updateReservation(@PathParam("id") Integer id, Reservation reservation) {
        if (id.equals(reservation.getId())) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("ID différent").build();
        } else {
            Reservation p = ReservationsDAO.getSingleton().getReservation(id);
            if (p == null) {
                return Response
                        .status(Response.Status.NOT_FOUND)
                        .entity("ID inexistant").build();
            }
        }

        ReservationsDAO.getSingleton().updateReservation(id, reservation);
        return Response.ok().build();
    }
}

/*
Tests Postman avec création de données Reservation :
{
    "pseudo": "bibi",
    "reserveShowId": 1,
    "reserved" : false
}

{
    "pseudo": "arthur_2548B",
    "reserveShowId": 1,
    "reserved": true
}

{
    "pseudo": "arthur_2548B",
    "reserveShowId": 2,
    "reserved": true
}
 */





/*
@GET
@Path("/{id}/validate")
@Produces(MediaType.APPLICATION_JSON)
public Response getReservationValidate(@PathParam("id") Integer id, Reservation reservation) {
    Show show = tickets.getShow(id);
    if (id.equals(show) && reservations.isReserved(reservation))
        reservations.getList();
    return Response.ok().build();
}*/
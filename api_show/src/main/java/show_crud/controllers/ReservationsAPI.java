package show_crud.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import show_crud.services.ReservationsDAO;
import show_crud.models.Reservation;
import show_crud.models.Show;
import show_crud.services.TicketsDAO;

import java.util.ArrayList;
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

    @GET
    @Path("/validated/{showId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reservation> getAllValidateReservation(@PathParam("showId") Integer showId) {
        List<Reservation> reservations = ReservationsDAO.getSingleton().getList();
        List<Reservation> validateReservation = new ArrayList<>();

        for (Reservation r:reservations){
            if(r.isReserved() && r.getReserveShowId().equals(showId)){
                validateReservation.add(r);
            }
        }
        return validateReservation;
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

        ReservationsDAO.getSingleton().addReservation(newReservation);
        return Response
                .status(Response.Status.CREATED) // 201
                .entity(newReservation).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteReservation(@PathParam("id") Integer id) {
        Reservation reservation = ReservationsDAO.getSingleton().getReservation(id);
        if (reservation.isReserved()) {
            return Response
                    .status(Response.Status.FORBIDDEN) // 403
                    .entity("Trop tard, c'est confirmé, vous ne pouvez plus supprimé")
                    .build();
        }

        ReservationsDAO.getSingleton().deleteReservation(id);
        return Response
                .noContent().build(); // send a 204 Status : No Content
    }
}

/*
Tests Postman avec création de données Reservation :
{
    "pseudo": "bibi-du-75",
    "reserveShowId": 1,
    "reserved" : true
}

{
    "pseudo": "arthur_2548B",
    "reserveShowId": 2,
    "reserved": false
}

{
    "pseudo": "arthur_2548B",
    "reserveShowId": 1,
    "reserved": true
}
 */
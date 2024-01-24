package show_crud.correction.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import show_crud.correction.Reservation;
import show_crud.correction.Spectacle;
import show_crud.correction.dao.ReservationsDAO;
import show_crud.correction.dao.SpectaclesDAO;

import java.util.List;

@Path("/reservations")
public class ReservationsAPI {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reservation> getAll(){
        return ReservationsDAO.getSingleton().getReservations();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Reservation r) {
        Spectacle spectacle = SpectaclesDAO.getSingleton().getById(r.getSpectacleId());
        if(spectacle == null){
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("ID du spectacle inconnu").build();
        } else {
            ReservationsDAO.getSingleton().addReservation(r);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(r).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response confirme(Reservation r){
        Reservation reservation = ReservationsDAO.getSingleton().getById(r.getId());
        if(reservation == null ){
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Reservation non trouvé").build();
        }else {
            if(r.isConfirmee()){
                return Response
                        .status(Response.Status.BAD_REQUEST)
                        .entity("Boolean nécessaire").build();
            } else {
                if(!r.getPseudo().equals(reservation.getPseudo())){
                    return Response
                            .status(Response.Status.BAD_REQUEST)
                            .entity("Pseudo non valable").build();
                } else {
                    if(!r.getId().equals(reservation.getId())){
                        return Response
                                .status(Response.Status.BAD_REQUEST)
                                .entity("ID non reconnu").build();
                    }else {
                        ReservationsDAO.getSingleton().update(r.getId(), r);
                        return 
                    }
                }
            }
        }
    }

}

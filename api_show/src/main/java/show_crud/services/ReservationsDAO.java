package show_crud.services;

import show_crud.models.Reservation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReservationsDAO {
    /**
     * Singleton pattern is used to ensure that there is only one
     * instance of ReservationsDAO in the application.
     */
    private static ReservationsDAO singleton;
    private ReservationsDAO() {}
    public static ReservationsDAO getSingleton() {
        if (singleton == null)
            singleton = new ReservationsDAO();
        return singleton;
    }

    /**
     * Counter for generating unique identifiers for shows.
     * Storage for shows. Key: showId, Value: Show object.
     */
    private int idCount = 0;
    private HashMap<Integer, Reservation> reservations = new HashMap<>();

    /**
     * Retrieves a list of all shows.
     * @return List of Show objects.
     */
    public List<Reservation> getList() {
        return reservations.values().stream().toList();
    }

    public void addReservation(Reservation newReservation) {
        idCount++;
        newReservation.setId(idCount);
        reservations.put(idCount, newReservation);
    }

    public Reservation getReservation(Integer id) {
        return reservations.get(id);
    }

    public void deleteReservation(Integer id){
        reservations.remove(id);
    }

    public void updateReservation(Integer id, Reservation reservation){
        reservations.replace(id, reservation);
    }

    public List<Reservation> getByShowId(Integer showId){
        ArrayList<Reservation> resultat = new ArrayList<>();
        for (Reservation r : reservations.values()){
            if(r.getReserveShowId().equals(showId))
                resultat.add(r);
        }
        return resultat;
    }
}

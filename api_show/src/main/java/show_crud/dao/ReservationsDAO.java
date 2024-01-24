package show_crud.dao;

import show_crud.models.Reservation;

import java.util.HashMap;
import java.util.List;

public class ReservationsDAO {
    private int idCount = 0;
    private HashMap<Integer, Reservation> persons = new HashMap<>();

    public List<Reservation> getList() {
        return persons.values().stream().toList();
    }

    public Reservation getReservation(int id) {
        return persons.get(id);
    }

    public void addReservation(Reservation newReservation) {
        idCount++;
        newReservation.setId(idCount);
        persons.put(idCount, newReservation);
    }

    public void deleteReservation(int id){
        persons.remove(id);
    }

    public void updateReservation(int id, Reservation reservation){
        persons.replace(id, reservation);
    }

    public boolean isReserved(Reservation reservation){
        reservation.setReserved(true);
        return true;
    }
}

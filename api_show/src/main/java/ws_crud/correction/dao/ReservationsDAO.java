package ws_crud.correction.dao;

import ws_crud.correction.Reservation;
import ws_crud.correction.Spectacle;

import java.util.HashMap;
import java.util.List;

public class ReservationsDAO {
    // On instancie le DAO ici dans un SINGLETON
    private static ReservationsDAO singleton; // au lieu on
    public static ReservationsDAO getSingleton(){
        if(singleton == null)
            singleton = new ReservationsDAO();
        return singleton;
    }
    private ReservationsDAO(){};

    private int idCount = 0;
    private HashMap<Integer, Spectacle> spectacles = new HashMap<>();

    public List<Spectacle> getReservations() {
        return spectacles.values().stream().toList();
    }

    public void addReservation(Spectacle newSpectacles) {
        idCount++;
        newSpectacles.setId(idCount);
        spectacles.put(idCount, newSpectacles);
    }

    public Reservation getById(Integer id) {
        return re
    }
}


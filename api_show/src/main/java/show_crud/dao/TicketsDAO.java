package show_crud.dao;

import show_crud.models.Show;

import java.util.HashMap;
import java.util.List;

public class TicketsDAO {
    /** On instancie le DAO ici dans un Singleton avec "static" pour pouvoir
    avoir une portée global dans toute l'application grâce à son Getteur */
    private static TicketsDAO singleton;

    public static TicketsDAO getSingleton() {
        if(singleton == null)
            singleton = new TicketsDAO();
        return singleton;
    }

    private TicketsDAO(){}
    /*** Singleton */

    private int idCount = 0;
    private HashMap<Integer, Show> shows = new HashMap<>();

    // Pour le GET
    public List<Show> getList() {
        return shows.values().stream().toList();
    }

    // Pour le POST - void ?
    public void addShow(Show newShow) {
        idCount++;
        newShow.setId(idCount);
        shows.put(idCount, newShow);
    }

    // Récupération de l'ID du show
    public Show getById(Integer showId){
        return shows.get(showId);
    }
}

/*
    // pour le GET (id)
    public Show getShow(int id) {
        return shows.get(id);
    }
 */

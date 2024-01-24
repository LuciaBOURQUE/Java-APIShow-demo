package show_crud.services;

import show_crud.models.Show;
import java.util.HashMap;
import java.util.List;

public class TicketsDAO {
    /**
     * Singleton pattern is used to ensure that there is only one
     * instance of TicketsDAO in the application.
     */
    private static TicketsDAO singleton;
    private TicketsDAO(){}
    public static TicketsDAO getSingleton() {
        if(singleton == null)
            singleton = new TicketsDAO();
        return singleton;
    }

    /**
     * Counter for generating unique identifiers for shows.
     * Storage for shows. Key: showId, Value: Show object.
     */
    private int idCount = 0;
    private HashMap<Integer, Show> shows = new HashMap<>();


    /**
     * Retrieves a list of all shows.
     * @return List of Show objects.
     */
    public List<Show> getList() {
        return shows.values().stream().toList();
    }

    public void addShow(Show newShow) {
        idCount++;
        newShow.setId(idCount);
        shows.put(idCount, newShow);
    }

    public Show getById(Integer showId){
        return shows.get(showId);
    }
}

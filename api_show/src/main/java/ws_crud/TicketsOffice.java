package ws_crud;

import java.util.HashMap;
import java.util.List;

public class TicketsOffice {
    private int idCount = 0;
    private HashMap<Integer, Show> shows = new HashMap<>();

    public List<Show> getList() {
        return shows.values().stream().toList();
    }

    public Show getShow(int id) {
        return shows.get(id);
    }

    public void addShow(Show newShow) {
        idCount++;
        newShow.setId(idCount);
        shows.put(idCount, newShow);
    }
}


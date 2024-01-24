package ws_crud.correction.dao;

import ws_crud.correction.Spectacle;
import java.util.HashMap;
import java.util.List;

public class SpectaclesDAO {
    // On instancie le DAO ici dans un SINGLETON
    private static SpectaclesDAO singleton; // au lieu on
    public static SpectaclesDAO getSingleton(){
        if(singleton == null)
            singleton = new SpectaclesDAO();
        return singleton;
    }
    private SpectaclesDAO(){};

    private int idCount = 0;
    private HashMap<Integer, Spectacle> spectacles = new HashMap<>();

    public List<Spectacle> getSpectacles() {
        return spectacles.values().stream().toList();
    }

    public void addSpecacle(Spectacle newSpectacles) {
        idCount++;
        newSpectacles.setId(idCount);
        spectacles.put(idCount, newSpectacles);
    }

    public Spectacle getById(Integer spectacleId) {
        return spectacles.get(spectacleId);
    }
}

package show_crud.correction;

public class Reservation {
    private Integer id;
    private Integer spectacleId;
    private String pseudo;
    private boolean confirmee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpectacleId() {
        return spectacleId;
    }

    public void setSpectacleId(Integer spectacleId) {
        this.spectacleId = spectacleId;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public boolean isConfirmee() {
        return confirmee;
    }

    public void setConfirmee(boolean confirmee) {
        this.confirmee = confirmee;
    }
}

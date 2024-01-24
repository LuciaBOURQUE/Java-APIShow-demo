package show_crud.models;

public class Reservation {
    private Integer id;

    private String pseudo;
    private Integer reserveShowId;
    private boolean reserved; // false

    public Reservation() {
    }

    public Reservation(String pseudo, Integer reserveShowId, boolean reserved) {
        this.pseudo = pseudo;
        this.reserveShowId = reserveShowId;
        this.reserved = reserved;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReserveShowId() {
        return reserveShowId;
    }

    public void setReserveShowId(Integer reserveShowId) {
        this.reserveShowId = reserveShowId;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", pseudo='" + pseudo + '\'' +
                ", reserveShowId=" + reserveShowId +
                ", reserved=" + reserved +
                '}';
    }
}

package ws_crud.correction;

public class Spectacle {
    private Integer id;
    private String title;
    private String date;
    private String hour;

    public Spectacle() {
    }

    public Spectacle(String title, String date, String hour) {
        this.title = title;
        this.date = date;
        this.hour = hour;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}

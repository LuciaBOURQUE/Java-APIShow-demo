package show_crud.models;

public class Show {
    private Integer id;

    private String title;
    private String date;
    private String place;
    private String hour;

    public Show() {
    }

    public Show(String title, String date, String place, String hour) {
        this.title = title;
        this.date = date;
        this.place = place;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", name='" + title + '\'' +
                ", date=" + date + '\'' +
                ", place='" + place + '\'' +
                ", hour='" + hour + '\'' +
                '}';
    }
}

//", date=" + getFormattedDate() +

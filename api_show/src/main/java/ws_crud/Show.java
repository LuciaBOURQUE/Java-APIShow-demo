package ws_crud;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Show {
    private Integer id;
    private String name;
    //private LocalDate date;
    private String date;
    private String place;
    private String hour;

    public Show() {
    }

    public Show(String name, String date, String place, String hour) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    // Formater la date
    /*
    public String getFormattedDate() {
        // Utilisez la méthode format de DateLocal ou LocalDate pour formater la date
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }*/

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date + '\'' +
                ", place='" + place + '\'' +
                ", hour='" + hour + '\'' +
                '}';
    }
}

//", date=" + getFormattedDate() +

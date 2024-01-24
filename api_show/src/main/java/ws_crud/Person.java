package ws_crud;

public class Person {
    private Integer id;
    private String pseudo;
    private Integer choiceShow;
    private boolean reserved;

    public Person() {
    }

    public Person(String pseudo, boolean reserved) {
        this.pseudo = pseudo;
        this.reserved = reserved;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChoiceShow() {
        return choiceShow;
    }

    public void setChoiceShow(Integer choiceShow) {
        this.choiceShow = choiceShow;
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
                ", choiceShow=" + choiceShow +
                ", reserved=" + reserved +
                '}';
    }
}

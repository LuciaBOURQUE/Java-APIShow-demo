package ws_crud;

import java.util.HashMap;
import java.util.List;

public class ReservationsOffice {
    private int idCount = 0;
    private HashMap<Integer, Person> persons = new HashMap<>();

    public List<Person> getList() {
        return persons.values().stream().toList();
    }

    public Person getReservation(int id) {
        return persons.get(id);
    }

    public void addReservation(Person newPerson) {
        idCount++;
        newPerson.setId(idCount);
        persons.put(idCount, newPerson);
    }

    public void deleteReservation(int id){
        persons.remove(id);
    }

    public void updateReservation(int id, Person person){
        persons.replace(id, person);
    }

    public boolean isReserved(Person person){
        person.setReserved(true);
        return true;
    }
}

package mx.com.hiringa.sga.service;

import mx.com.hiringa.sga.domain.Person;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PersonServiceRemoteImpl implements PersonServiceRemote {

    @Override
    public List<Person> ListPerson() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Richard", "Müller", "rihar.muller@mail.com", "5591111715"));
        persons.add(new Person(2, "John", "Wick", "jowh.wick@mail.com", "5583728394"));
        return persons;
    }

    @Override
    public Person FindPersonById(Person person) {
        return null;
    }

    @Override
    public Person FindPersonByEmail(Person person) {
        return null;
    }

    @Override
    public void AddPerson(Person person) {
    }

    @Override
    public void ModifyPerson(Person person) {
    }

    @Override
    public void DeletePerson(Person person) {
    }
}

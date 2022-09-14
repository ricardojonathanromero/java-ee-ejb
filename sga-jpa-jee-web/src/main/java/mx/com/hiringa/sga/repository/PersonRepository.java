package mx.com.hiringa.jpa.repository;

import mx.com.hiringa.jpa.domain.entities.Person;

import java.util.List;

public interface PersonRepository {
    List<Person> findAll();
    Person findPersonById(Person person);
    Person findPersonByEmail(Person person);
    void createPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(Person person);
}

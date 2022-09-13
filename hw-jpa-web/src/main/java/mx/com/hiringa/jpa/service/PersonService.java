package mx.com.hiringa.jpa.service;

import mx.com.hiringa.jpa.domain.entities.Person;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PersonService {
    List<Person> ListPersons();
    Person FindPersonById(Person person);
    Person FindPersonByEmail(Person person);
    void AddPerson(Person person);
    void ModifyPerson(Person person);
    void DeletePerson(Person person);
}

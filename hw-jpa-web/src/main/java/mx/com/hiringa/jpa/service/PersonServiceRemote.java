package mx.com.hiringa.sga.service;

import mx.com.hiringa.sga.domain.entities.Person;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface PersonServiceRemote {
    List<Person> ListPersons();
    Person FindPersonById(Person person);
    Person FindPersonByEmail(Person person);
    void AddPerson(Person person);
    void ModifyPerson(Person person);
    void DeletePerson(Person person);
}

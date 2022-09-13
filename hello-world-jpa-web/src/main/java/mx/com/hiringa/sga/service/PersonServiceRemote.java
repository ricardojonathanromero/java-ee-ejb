package mx.com.hiringa.sga.service;

import jakarta.ejb.Remote;
import mx.com.hiringa.sga.domain.Person;

import java.util.List;

@Remote
public interface PersonServiceRemote {
    List<Person> ListPerson();
    Person FindPersonById(Person person);
    Person FindPersonByEmail(Person person);
    void AddPerson(Person person);
    void ModifyPerson(Person person);
    void DeletePerson(Person person);
}

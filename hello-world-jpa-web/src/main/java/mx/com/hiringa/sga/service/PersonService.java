package mx.com.hiringa.sga.service;

import jakarta.ejb.Local;
import mx.com.hiringa.sga.domain.Person;

import java.util.List;

@Local
public interface PersonService {
    List<Person> ListPerson();
    Person FindPersonById(Person person);
    Person FindPersonByEmail(Person person);
    void AddPerson(Person person);
    void ModifyPerson(Person person);
    void DeletePerson(Person person);
}

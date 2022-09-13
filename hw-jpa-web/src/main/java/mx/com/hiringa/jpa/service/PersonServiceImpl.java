package mx.com.hiringa.jpa.service;

import mx.com.hiringa.jpa.domain.entities.Person;
import mx.com.hiringa.jpa.repository.PersonRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PersonServiceImpl implements PersonServiceRemote, PersonService {
    @Inject
    private PersonRepository repo;

    @Override
    public List<Person> ListPersons() { return repo.findAll(); }

    @Override
    public Person FindPersonById(Person person) {
        return repo.findPersonById(person);
    }

    @Override
    public Person FindPersonByEmail(Person person) {
        return repo.findPersonByEmail(person);
    }

    @Override
    public void AddPerson(Person person) {
        repo.createPerson(person);
    }

    @Override
    public void ModifyPerson(Person person) {
        repo.updatePerson(person);
    }

    @Override
    public void DeletePerson(Person person) {
        repo.deletePerson(person);
    }
}

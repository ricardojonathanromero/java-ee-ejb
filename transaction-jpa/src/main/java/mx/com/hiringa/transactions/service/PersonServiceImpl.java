package mx.com.hiringa.transactions.service;

import mx.com.hiringa.transactions.domain.Person;
import mx.com.hiringa.transactions.dao.PersonDao;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;

import java.util.List;

@Stateless
public class PersonServiceImpl implements PersonServiceRemote, PersonService {
    @Inject
    PersonDao repo;

    @Resource
    private SessionContext context;

    @Override
    public List<Person> ListPersons() { return repo.findAll(); }

    @Override
    public Person FindPersonById(Person person) { return repo.findPersonById(person); }

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
        try {
            repo.updatePerson(person);
        } catch (Throwable t) {
            context.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void DeletePerson(Person person) {
        repo.deletePerson(person);
    }
}

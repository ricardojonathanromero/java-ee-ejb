package mx.com.hiringa.sga.repository;

import mx.com.hiringa.sga.domain.Person;
import org.jetbrains.annotations.NotNull;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonRepositoryImpl implements PersonRepository {
    @PersistenceContext(name = "persistence")
    EntityManager em;

    @Override
    public List<Person> findAll() { return em.createNamedQuery("FindAllPersons").getResultList(); }

    @Override
    public Person findPersonById(@NotNull Person person) { return em.find(Person.class, person.getId()); }

    @Override
    public Person findPersonByEmail(@NotNull Person person) {
        return (Person) em.
                createNamedQuery("FindPersonByEmail").
                setParameter("email", person.getEmail()).getSingleResult();
    }

    @Override
    public void createPerson(Person person) { em.persist(person); }

    @Override
    public void updatePerson(Person person) { em.merge(person); }

    @Override
    public void deletePerson(Person person) { em.remove(em.merge(person)); }
}

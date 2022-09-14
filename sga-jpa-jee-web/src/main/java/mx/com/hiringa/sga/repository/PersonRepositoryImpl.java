package mx.com.hiringa.jpa.repository;

import mx.com.hiringa.jpa.domain.entities.Person;
import org.jetbrains.annotations.NotNull;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonRepositoryImpl implements PersonRepository {
    @PersistenceContext(name = "PersonPU")
    EntityManager em;

    @Override
    public List<Person> findAll() {
        System.out.println("************ Start findAll() function ***********");
        return (List<Person>) em.createNamedQuery("FindAllPersons").getResultList();
    }

    @Override
    public Person findPersonById(@NotNull Person person) {
        return em.find(Person.class, person.getId());
    }

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

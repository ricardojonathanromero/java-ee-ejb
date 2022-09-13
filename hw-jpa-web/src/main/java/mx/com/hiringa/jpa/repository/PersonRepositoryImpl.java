package mx.com.hiringa.sga.repository;

import mx.com.hiringa.sga.domain.entities.Person;
import org.jetbrains.annotations.NotNull;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class PersonRepositoryImpl implements PersonRepository {
    @PersistenceContext(name = "PersonPU")
    EntityManager em;

    @Override
    public List<Person> findAll() {
        Query q = em.createQuery("SELECT p FROM persons p ORDER BY p.id");
        return (List<Person>) q.getResultList();
    }

    @Override
    public Person findPersonById(@NotNull Person person) {
        return em.find(Person.class, person.getId());
    }

    @Override
    public Person findPersonByEmail(@NotNull Person person) {
        Query q = em.createQuery("SELECT p FROM persons p WHERE p.email =: email");
        q.setParameter("email", person.getEmail());
        return (Person) q.getSingleResult();
    }

    @Override
    public void createPerson(Person person) {
        em.persist(person);
    }

    @Override
    public void updatePerson(Person person) { em.merge(person); }

    @Override
    public void deletePerson(Person person) { em.remove(em.merge(person)); }
}

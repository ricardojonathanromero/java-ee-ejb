package mx.com.hiringa.sga.associations;

import mx.com.hiringa.sga.domain.Person;
import mx.com.hiringa.sga.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AssociationsJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        List<Person> people = em.createNamedQuery("FindAllPersons").getResultList();

        em.close();

        printPeople(people);
    }

    private static void printPeople(List<Person> people) {
        for (Person person: people) {
            System.out.println(people);
            for (User user: person.getUsers()) {
                System.out.println("User => " + user);
            }
        }
    }
}

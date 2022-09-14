package mx.com.hiringa.sga.associations;

import mx.com.hiringa.sga.domain.Person;
import mx.com.hiringa.sga.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CascadePersistenceJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Person person = new Person("Josep", "Allah", "joseph@gmail.com", "6643929625");

        User user = new User("josep273", "my_password", person);

        tx.begin();

        em.persist(user);

        tx.commit();

        System.out.println("object persisted User: " + user);
        System.out.println("object persisted Person: " + person);
        em.close();
    }
}

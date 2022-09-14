package mx.com.hiringa.sga.associations;

import mx.com.hiringa.sga.domain.Person;
import mx.com.hiringa.sga.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CascadePersistenceJPA2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Person person = new Person("Lewis", "Hamilton", "lewis.ham@gmail.com", "5563748293");

        User user = new User("lewes.paps", "myPassW0rd", person);

        tx.begin();

        em.persist(user);

        tx.commit();

        em.close();
    }
}

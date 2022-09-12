package mx.com.hiringa.sga.client;

import mx.com.hiringa.sga.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        log.debug("start main application");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // start transaction
        tx.begin();

        // create person
        log.debug("start person object creation");
        Person person = new Person("Ricardo", "Romero", "ricardo.romero@mail.com", "5531492549");
        log.debug("person: " + person);
        em.persist(person);

        // end transaction
        tx.commit();
        log.debug("end transaction");
        em.close();
    }
}

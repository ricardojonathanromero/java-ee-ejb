package mx.com.hiringa.sga.jpql.client;

import mx.com.hiringa.sga.jpql.domain.Person;
import mx.com.hiringa.sga.jpql.domain.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Iterator;
import java.util.List;

public class JPQL {
    static final Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        String jpql = null;
        Object[] tuple = null;
        Iterator items = null;
        List<Person> people = null;
        List<User> users = null;
        Person person = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        log.info("get all people");
        jpql = "select p from Person p order by p.id";
        people = em.createQuery(jpql).getResultList();
        log.info("************ printing people ************");
        printPeople(people);

        log.info("query for person with id 1");

        jpql = "select p from Person p where p.id = 1";
        person = (Person) em.createQuery(jpql).getSingleResult();
        log.info(person);

        log.info("filtering by name = 'Ricardo'");
        jpql = "select p from Person p where p.name = 'Ricardo'";
        people = em.createQuery(jpql).getResultList();

        log.info("************ printing people by name filter ************");
        printPeople(people);

        log.info("");
        log.info("================================================");
        log.info("");
        log.info("tupla query creation...");
        jpql = "select p.name as name, p.lastName as lastName, p.email as email from Person p";
        items = em.createQuery(jpql).getResultList().iterator();

        while (items.hasNext()) {
            tuple = (Object[]) items.next();
            String name = (String) tuple[0];
            String lastname = (String) tuple[1];
            String email = (String) tuple[2];

            log.info("name=" + name + ", last_name=" + lastname + ", email=" + email);
        }

        log.info("");
        log.info("================================================");
        log.info("");
        log.info("get person object and id");
        jpql = "select p, p.id from Person p order by p.id";
        items = em.createQuery(jpql).getResultList().iterator();
        while (items.hasNext()) {
            tuple = (Object[]) items.next();
            person = (Person) tuple[0];
            Integer id = (Integer) tuple[1];
            log.info("person_complete=" + person + ", id=" + id);
        }

        log.info("");
        log.info("================================================");
        log.info("");
        log.info("get person just with id filled and rest field nulls");
        jpql = "select new mx.com.hiringa.sga.jpql.domain.Person (p.id) from Person p";
        people = em.createQuery(jpql).getResultList();
        printPeople(people);

        log.info("");
        log.info("================================================");
        log.info("");
        log.info("get min and max from 'persons' table");
        jpql = "select min(p.id) as minId, max(p.id) as maxId, count(p.id) as total from Person p";
        items = em.createQuery(jpql).getResultList().iterator();
        while (items.hasNext()) {
            tuple = (Object[]) items.next();
            Integer minId = (Integer) tuple[0];
            Integer maxId = (Integer) tuple[1];
            Long total = (Long) tuple[2];
            log.info("minId=" + minId + ", maxId=" + maxId + ", totalItems=" + total);
        }

        log.info("");
        log.info("================================================");
        log.info("");
        log.info("count distinct names");
        jpql = "select count(distinct p.name) from Person p";
        Long counter = (Long) em.createQuery(jpql).getSingleResult();
        log.info("distinct name count: " + counter);

        log.info("");
        log.info("================================================");
        log.info("");
        log.info("concat name and lastname then upper fullName");
        jpql = "select concat(p.name, ' ', p.lastName) as fullName from Person p";
        List<String> names = em.createQuery(jpql).getResultList();
        printNames(names);

        log.info("");
        log.info("================================================");
        log.info("");
        log.info("get person object with id based on param passed");
        jpql = "select p from Person p where p.id = :id";
        person = (Person) em.createQuery(jpql).setParameter("id", 12).getSingleResult();
        log.info("person found! => " + person);

        log.info("");
        log.info("================================================");
        log.info("");
        log.info("get persons with an 'a' in their names");
        jpql = "select p from Person p where upper(p.name) like upper(:name) or upper(p.lastName) like upper(:name)";
        people = em.createQuery(jpql).setParameter("name", "%a%").getResultList();
        printPeople(people);

        log.info("");
        log.info("================================================");
        log.info("");
        log.info("between use");
        jpql = "select p from Person p where p.id between 1 and 20";
        people = em.createQuery(jpql).getResultList();
        printPeople(people);

        log.info("");
        log.info("================================================");
        log.info("");
        log.info("order use");
        jpql = "select p from Person p where p.id > 0 order by p.name desc, p.lastName desc";
        people = em.createQuery(jpql).getResultList();
        printPeople(people);

        log.info("");
        log.info("================================================");
        log.info("");
        log.info("subqueries in postgresql");
        jpql = "select p from Person p where p.id in (select min(p2.id) from Person p2)";
        people = em.createQuery(jpql).getResultList();
        printPeople(people);

        log.info("");
        log.info("================================================");
        log.info("");
        log.info("use of joins with lazy loading");
        jpql = "select u from User u join u.person p";
        users = (List<User>) em.createQuery(jpql).getResultList();
        printUsers(users);

        log.info("");
        log.info("================================================");
        log.info("");
        log.info("use of joins with eager loading");
        jpql = "select u from User u left join fetch u.person";
        users = (List<User>) em.createQuery(jpql).getResultList();
        printUsers(users);
    }

    private static void printPeople(List<Person> people) {
        for (Person person : people) {
            log.info(person);
        }
    }

    private static void printUsers(List<User> users) {
        for (User user : users) {
            log.info(user);
        }
    }

    private static void printNames(List<String> names) {
        for (String name: names) {
            log.info("FullName=" + name);
        }
    }
}

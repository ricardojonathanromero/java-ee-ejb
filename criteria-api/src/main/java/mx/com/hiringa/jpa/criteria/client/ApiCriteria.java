package mx.com.hiringa.jpa.criteria.client;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mx.com.hiringa.jpa.criteria.domain.Person;

public class ApiCriteria {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        // define variables
        CriteriaBuilder cb = null;
        CriteriaQuery<Person> criteriaQuery = null;
        Root<Person> fromPerson = null;
        TypedQuery<Person> query = null;
        Person person = null;
        List<Person> people = null;
        
        log.info("");
        log.info("====================================================");
        log.info("================= Simple ALL Query =================");
        log.info("====================================================");
        log.info("creates instance type CriteriaBuilder from EntityManager object");
        log.info("");
        cb = em.getCriteriaBuilder();

        log.info("creating CriteriaQuery object...");
        criteriaQuery = cb.createQuery(Person.class);

        log.info("create root object");
        fromPerson = criteriaQuery.from(Person.class);

        log.info("select needed from 'from'");
        criteriaQuery.select(fromPerson);

        log.info("create 'TypeSafe' query");
        query = em.createQuery(criteriaQuery);

        log.info("exec query...");
        people = query.getResultList();

        printPeople(people);

        log.info("");
        log.info("====================================================");
        log.info("================= QueryFilter ByID =================");
        log.info("====================================================");
        log.info("creates instance type CriteriaBuilder from EntityManager object");
        log.info("");
        cb = em.getCriteriaBuilder();

        log.info("creating CriteriaQuery object...");
        criteriaQuery = cb.createQuery(Person.class);

        log.info("create root object");
        fromPerson = criteriaQuery.from(Person.class);

        log.info("select Person where id is equals to 1");
        criteriaQuery.select(fromPerson).where(cb.equal(fromPerson.get("id"), 1));
        
        log.info("create 'TypeSafe' query");
        query = em.createQuery(criteriaQuery);

        log.info("exec query...");
        person = query.getSingleResult();

        log.info("printing single person");
        log.info(person);

        log.info("");
        log.info("====================================================================");
        log.info("================= QueryFilter ByID With predicates =================");
        log.info("====================================================================");
        log.info("creates instance type CriteriaBuilder from EntityManager object");
        log.info("");
        cb = em.getCriteriaBuilder();

        log.info("creating CriteriaQuery object...");
        fromPerson = cb.createQuery(Person.class).from(Person.class);

        log.info("select Person where id is equals to 1 with predicates");
        criteriaQuery.select(fromPerson);

        log.info("defining predicates dynamically");
        List<Predicate> criterias = new ArrayList<Predicate>();
        Integer id = 1;
        ParameterExpression<Integer> parameter = cb.parameter(Integer.class, "id");
        criterias.add(cb.equal(fromPerson.get("id"), parameter));

        if (criterias.isEmpty()) {
            throw new RuntimeException("query without criterias");
        } else if (criterias.size() == 1) {
            // criterias has only one criteria
            criteriaQuery.where(criterias.get(0));
        } else {
            // criterias has more than one criteria and will be append as 'and' sentence
            criteriaQuery.where(cb.and(criterias.toArray(new Predicate[0])));
        }
        
        log.info("create 'TypeSafe' query");
        query = em.createQuery(criteriaQuery);

        log.info("set parameters to query");
        query.setParameter("id", id);

        log.info("exec query...");
        person = query.getSingleResult();

        log.info("printing single person");
        log.info(person);
    }

    private static void printPeople(List<Person> people) {
        for (Person person: people) {
            log.info(person);
        }
    }
}

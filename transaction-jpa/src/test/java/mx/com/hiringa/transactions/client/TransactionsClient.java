package mx.com.hiringa.transactions.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mx.com.hiringa.transactions.domain.Person;
import mx.com.hiringa.transactions.service.PersonServiceRemote;

public class TransactionsClient {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        try {
            log.info("start main app()");
            Properties jndiProps = new Properties();
            jndiProps.put(Context.INITIAL_CONTEXT_FACTORY,"org.wildfly.naming.client.WildFlyInitialContextFactory");
            jndiProps.put(Context.PROVIDER_URL,"http-remoting://localhost:8080");
            jndiProps.put(Context.SECURITY_PRINCIPAL, "testuser");
            jndiProps.put(Context.SECURITY_CREDENTIALS, "HKKbRz6yCXmsxcTaju3D4Hru4eBpT.");
            jndiProps.put("jboss.naming.client.ejb.context", true);

            Context ctx = new InitialContext(jndiProps);
            PersonServiceRemote personServiceRemote = (PersonServiceRemote) ctx.lookup("ejb:/transactions-jpa/PersonServiceImpl!mx.com.hiringa.transactions.service.PersonServiceRemote");
            
            log.info("initializing test for transaction management for PersonService");

            log.info("looking for person object");
            Person person = personServiceRemote.FindPersonById(new Person(1));

            log.info("person_found: " + person);

            log.info("changing last_name field...");
            person.setLastName("Romero");

            personServiceRemote.ModifyPerson(person);

            log.info("object modified: " + person);

            log.info("ends EJB transaction test");

        } catch (NamingException e) {
            log.error(e.getMessage());
            log.error(e.getCause());
            log.error("generic error: " + e.getMessage());
        }
    }
}

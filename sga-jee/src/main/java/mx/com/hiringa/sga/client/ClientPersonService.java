package mx.com.hiringa.sga.client;

import mx.com.hiringa.sga.domain.Person;
import mx.com.hiringa.sga.service.PersonServiceRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;

public class ClientPersonService {
    public static void main(String[] args) {
        System.out.println("Initializing call to EJB from client");
        try {
            Context jndi = new InitialContext();
            PersonServiceRemote personService = (PersonServiceRemote) jndi.lookup("ejb:/sga-jee-1.0.0/PersonServiceRemoteImpl!mx.com.hiringa.sga.service.PersonServiceRemote");

            List<Person> persons = personService.ListPerson();

            for (Person person : persons) {
                System.out.println(person);
            }

            System.out.println("End call to EJB from client");
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
    }
}

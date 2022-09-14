package mx.com.hiringa.jpa.handler;

import mx.com.hiringa.jpa.domain.entities.Person;
import mx.com.hiringa.jpa.service.PersonService;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "persons", value = "/persons", description = "persons service")
public class PersonServlet extends HttpServlet {
    @Inject
    PersonService personService;

    protected void doGet(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Person> personList = personService.ListPersons();
        System.out.println("---------------------------------");
        System.out.println("persons: " + personList.toString() + " -- end");
        System.out.println("---------------------------------");
        request.setAttribute("persons", personList);
        request.getRequestDispatcher("/personList.jsp").forward(request, response);
    }
}

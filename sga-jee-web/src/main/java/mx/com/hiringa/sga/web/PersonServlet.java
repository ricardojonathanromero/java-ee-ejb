package mx.com.hiringa.sga.web;

import java.io.*;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import mx.com.hiringa.sga.domain.Person;
import mx.com.hiringa.sga.service.PersonService;

@WebServlet(name = "persons", value = "/persons")
public class PersonServlet extends HttpServlet {
    @Inject
    PersonService personService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Person> personList = personService.ListPerson();
        System.out.println("---------------------------------");
        System.out.println("persons: " + personList.toString() + " -- end");
        System.out.println("---------------------------------");
        request.setAttribute("persons", personList);
        request.getRequestDispatcher("/personList.jsp").forward(request, response);
    }
}
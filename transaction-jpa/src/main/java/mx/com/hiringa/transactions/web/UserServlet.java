package mx.com.hiringa.transactions.web;

import mx.com.hiringa.transactions.domain.User;
import mx.com.hiringa.transactions.service.UserService;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "users", value = "/users", description = "returns list of users")
public class UserServlet extends HttpServlet {
    @Inject
    UserService userService;

    protected void doGet(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userService.ListUsers();
        System.out.println("---------------------------------");
        System.out.println("users: " + users + " -- end");
        System.out.println("---------------------------------");
        request.setAttribute("users", users);
        request.getRequestDispatcher("/users.jsp").forward(request, response);
    }
}

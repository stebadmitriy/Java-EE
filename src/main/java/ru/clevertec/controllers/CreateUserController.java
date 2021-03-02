package ru.clevertec.controllers;

import com.google.gson.Gson;
import ru.clevertec.entities.User;
import ru.clevertec.entities.UserType;
import ru.clevertec.repositories.UserApiRepository;
import ru.clevertec.repositories.UserRepository;
import ru.clevertec.services.UserApiService;
import ru.clevertec.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@WebServlet(urlPatterns = {"/user/create"},
        initParams = {
                @WebInitParam(name = "count", value = "3")
        })
public class CreateUserController extends HttpServlet {
    private int count;
    private final List<User> users = new ArrayList<>();
    private final UserRepository<User> userRepository = new UserApiRepository(users);
    private final UserService<User> userService = new UserApiService(userRepository);
    public static final String USER_LIST_PATH = "/user/select";

    @Override
    public void init() throws ServletException {
        System.out.println("Initialization servlet");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        count = Integer.parseInt(config.getInitParameter("count"));
        System.out.println("count is " + count);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Gson gson = new Gson();
        User u = gson.fromJson(reader, User.class);

        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        int age = Integer.parseInt(req.getParameter("age"));
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserType userType = UserType.valueOf(req.getParameter("userType"));

        HashMap<String, String> credentials = new HashMap<>();
        credentials.put(login, password);

        User user = new User(firstName, secondName, age, credentials, userType);
        userService.createUser(user);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(USER_LIST_PATH);
        requestDispatcher.forward(req, resp);

        if (Objects.nonNull(req.getSession())
                && Objects.isNull(req.getSession().getAttribute("userType"))) {
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("userType", userType);
            System.out.println("!!!!!");
        }


    }

    @Override
    public void destroy() {
        System.out.println("destroy servlet");
    }
}

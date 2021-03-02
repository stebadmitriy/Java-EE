package ru.clevertec.controllers;


import ru.clevertec.repositories.UserApiRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/user/select"})
public class SelectUserController extends HttpServlet {


    public static final String PAGE_LIST_USERS = "/pages/user/list_users.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PAGE_LIST_USERS);
        req.setAttribute("users", UserApiRepository.getUsers());
        requestDispatcher.forward(req, resp);

    }
}

package ru.clevertec.controllers;

import ru.clevertec.entities.UserType;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebFilter(urlPatterns = {"/user/*"})
public class AuthorizationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        if (Objects.nonNull(session) && Objects.nonNull(session.getAttribute("userType"))) {
            UserType userType = (UserType) session.getAttribute("userType");
            if (userType == UserType.ADMIN) {
                chain.doFilter(request, response);
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/errors/authorization_error.jsp");
                requestDispatcher.forward(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }

    }
}

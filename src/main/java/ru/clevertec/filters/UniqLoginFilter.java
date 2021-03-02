package ru.clevertec.filters;

import ru.clevertec.entities.User;
import ru.clevertec.repositories.UserApiRepository;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Optional;

@WebFilter(urlPatterns = {"/user/*"})
public class UniqLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/errors/login_error.jsp");
        Optional<User> userOptional = UserApiRepository.getUsers()
                .stream()
                .filter(user -> user.getCredentials().containsKey(request.getParameter("login")))
                .findFirst();

        if (userOptional.isPresent()) {
            requestDispatcher.forward(request, response);

        } else {
            chain.doFilter(request, response);
        }


    }
}

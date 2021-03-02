package ru.clevertec.filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@WebFilter(urlPatterns = {"/user/*"})
public class RequestLogFilter implements Filter {
    private final Logger log = Logger.getLogger(RequestLogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        Map<String, ArrayList<String>> headers = getHeaders(httpServletRequest);
        log.info(httpServletRequest.getRequestURL() + ":" + headers);

        chain.doFilter(request, response);


    }

    private Map<String, ArrayList<String>> getHeaders(HttpServletRequest httpServletRequest) {
        return Collections.list(httpServletRequest.getHeaderNames())
                .stream()
                .collect(Collectors.toMap(
                        Function.identity(),//Возвращает функцию, которая всегда возвращает свой входной аргумент.
                        h -> Collections.list(httpServletRequest.getHeaders(h))
                ));
    }
}

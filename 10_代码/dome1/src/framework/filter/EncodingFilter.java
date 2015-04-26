package framework.filter;

import java.io.*;

import javax.servlet.*;

public class EncodingFilter implements Filter {

    public EncodingFilter() {
        config = null;
    }

    public void init(FilterConfig conf) {
        config = conf;
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding(config.getInitParameter("encoding"));
        chain.doFilter(request, response);
    }

    private FilterConfig config;
}
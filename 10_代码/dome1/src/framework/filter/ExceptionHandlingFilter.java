package framework.filter;
import java.io.*;

import javax.servlet.*;

import org.apache.openjpa.persistence.*;
import org.springframework.dao.*;

public class ExceptionHandlingFilter implements Filter {

    @SuppressWarnings("unused")
	private boolean error_flag = false;


    public ExceptionHandlingFilter() {
    }

    public void destroy() {
    }
    public final void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try {
            chain.doFilter(request, response);
        } catch (IOException handlingException) {
            error_flag  = true;
        } catch (ServletException handlingException) {
            error_flag  = true;
        } catch (DataAccessResourceFailureException handlingException) {
//            String message = String.format("DB connect error!");
//            RuntimeException e = new RuntimeException(message);
            error_flag  = true;
        } catch (PersistenceException handlingException) {
            error_flag  = true;
        } catch (Exception handlingException) {
            error_flag  = true;
        } catch (Error handlingException) {
            error_flag  = true;
        }
//        if(error_flag == true){
//
//            RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
//            request.setAttribute("Error_msg", "データベース　接続できません。");
//            rd.forward(request, response);
//        }
    }

    public void init(FilterConfig filterconfig) throws ServletException {
    }

}


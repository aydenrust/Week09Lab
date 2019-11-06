/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 795347
 */
public class AdminFilter implements Filter{
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        // code that is executed before the servlet
        
        HttpServletRequest hsr = (HttpServletRequest)request;
        HttpSession session = hsr.getSession();
        
        if (session.getAttribute("email") == null) {
            HttpServletResponse hsre = (HttpServletResponse)response;
            hsre.sendRedirect("test");
            return;
        } 
        
         // allow the user to access the servlet
         if(session.getAttribute("email") == "admin@admin.com"){
           chain.doFilter(request, response);  
         }
         
         
         // code that is executed after the servlet
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }

    @Override
    public void destroy() {
        
    }

}

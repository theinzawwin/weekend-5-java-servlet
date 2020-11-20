package com.best.jee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class StudentFilter
 */
@WebFilter(urlPatterns = "/StudentServlet/*")//{"/StudentServlet/**","/GradeServlet"}
public class StudentFilter implements Filter {

    /**
     * Default constructor. 
     */
    public StudentFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		//PrintWriter out=response.getWriter();  
	    System.out.println("filter is invoked before"); 
	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse res=(HttpServletResponse)response;
	    HttpSession session=req.getSession();
	   
	     if(session.getAttribute("userName")!=null) {
	    	 chain.doFilter(request, response);//sends request to next resource  
	     }else {
	    	 res.sendRedirect("GradeServlet");
	     }
	    	
	          
	    System.out.println("filter is invoked after");  
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

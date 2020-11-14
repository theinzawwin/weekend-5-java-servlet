package com.best.jee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.best.jee.model.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static List<Student> studentList=new ArrayList<Student>();
    /**
     * Default constructor. 
     */
    public StudentServlet() {
        // TODO Auto-generated constructor stub
    	studentList.add(new Student(1L,"Mg Mg","5/kama/3434","yangon","1cs-1") );
    	studentList.add(new Student(2L,"Ma Ma","5/kama/3434","Mdy","1cs-2") );
    	studentList.add(new Student(3L,"Ko Ko","10/yatana/3434","Yangon","1cs-3") );
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setContentType("text/html");
		//response.getWriter().print("<h3>Welcome From B&B Institute</h3><p>Your future will be better</p>");
		RequestDispatcher rd=request.getRequestDispatcher("student.jsp");
		request.setAttribute("studentList", studentList);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		response.getWriter().println("Your Name "+name+" and Phone number is "+phone+", Address is "+address);
		//doGet(request, response);
	}

}

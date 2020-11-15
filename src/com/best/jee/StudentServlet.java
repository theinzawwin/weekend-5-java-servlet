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

import com.best.dao.StudentDao;
import com.best.jee.model.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static List<Student> studentList=new ArrayList<Student>();
	public StudentDao studentDao;
    /**
     * Default constructor. 
     */
    public StudentServlet() {
        // TODO Auto-generated constructor stub
    	studentList.add(new Student(1L,"Mg Mg","5/kama/3434","yangon","1cs-1") );
    	studentList.add(new Student(2L,"Ma Ma","5/kama/3434","Mdy","1cs-2") );
    	studentList.add(new Student(3L,"Ko Ko","10/yatana/3434","Yangon","1cs-3") );
    	studentDao=new StudentDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setContentType("text/html");
		//response.getWriter().print("<h3>Welcome From B&B Institute</h3><p>Your future will be better</p>");
		RequestDispatcher rdlist=request.getRequestDispatcher("student.jsp");
		String action=request.getParameter("action");
		switch(action) {
		case "new":
			RequestDispatcher rd=request.getRequestDispatcher("create_student.jsp");
			rd.forward(request, response);
			break;
		case "list":
			
			try {
				request.setAttribute("studentList", studentDao.getStudentList());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rdlist.forward(request, response);
			break;
		case "update":
			break;
		default:

			try {
				request.setAttribute("studentList", studentDao.getStudentList());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rdlist.forward(request, response);
			break;
		}
		/*RequestDispatcher rd=request.getRequestDispatcher("create_student.jsp");
		
		try {
			request.setAttribute("studentList", studentDao.getStudentList());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rd.forward(request, response);
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String nrc=request.getParameter("nrc");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		Student std=new Student(0L, name, nrc, phone, address);
		try {
			String message="";
			boolean result=studentDao.saveStudent(std);
			if(result) {
				message="Successfully Saved";
			}else {
				message="Unsuccessful";
			}
			RequestDispatcher rd=request.getRequestDispatcher("student.jsp");
			request.setAttribute("studentList", studentDao.getStudentList());
			request.setAttribute("message", message);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//response.getWriter().println("Your Name "+name+" and Phone number is "+phone+", Address is "+address);
		//doGet(request, response);
	}

}

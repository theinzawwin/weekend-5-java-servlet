package com.best.jee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.best.dao.GradeDao;
import com.best.jee.model.Grade;

/**
 * Servlet implementation class GradeServlet
 */
@WebServlet("/GradeServlet")
public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private GradeDao gradeDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeServlet() {
    	
        super();
        gradeDao=new GradeDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		session.setAttribute("userName", "bestBright");
		RequestDispatcher create_rd=request.getRequestDispatcher("create_grade.jsp");
		RequestDispatcher list_rd=request.getRequestDispatcher("grade_list.jsp");
		action="new";
		switch(action) {
		case "new":
			create_rd.forward(request, response);
			break;
		case "list":
			try {
				request.setAttribute("gradeList", gradeDao.getGradeList());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list_rd.forward(request, response);
			break;
		default:
			try {
				request.setAttribute("gradeList", gradeDao.getGradeList());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list_rd.forward(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String teacherName=request.getParameter("teacherName");
		Grade g=new Grade(0L,name,teacherName);
		try {
			boolean result=gradeDao.saveGrade(g);
			RequestDispatcher list_rd=request.getRequestDispatcher("grade_list.jsp");
			try {
				request.setAttribute("gradeList", gradeDao.getGradeList());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list_rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

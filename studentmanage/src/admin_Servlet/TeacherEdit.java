package admin_Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin_Dao.AcdemyDao;
import admin_Dao.TeacherDao;
import bean.Acdemy;
import bean.TeacherList;

/**
 * Servlet implementation class TeachetEdit
 */
@WebServlet("/TeachetEdit")
public class TeacherEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int teacherId = Integer.parseInt(request.getParameter("id"));
		System.out.println(teacherId);
		TeacherDao dao = new TeacherDao();
		TeacherList bean = null;
		ArrayList<Acdemy> list = null;
		AcdemyDao dao1 = new AcdemyDao();
		try {
			bean = dao.teacher(teacherId);
			list = dao1.List();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(bean.getAcdemyId());
		request.setAttribute("bean", bean);
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin_TeacherEdit.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

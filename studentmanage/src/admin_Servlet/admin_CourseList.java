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
import admin_Dao.CourseDao;
import bean.Acdemy;
import bean.CourseList;
import util.Pager;

/**
 * Servlet implementation class admin_CourseList
 */

public class admin_CourseList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_CourseList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String curPage = request.getParameter("cur_page");
		String courseId = request.getParameter("courseId");
		String courseName = request.getParameter("courseName");
		String courseCredits =request.getParameter("courseCredits");
		ArrayList<CourseList> allcourse = null;
		CourseDao coursedao = new CourseDao();
		
		if (curPage == null || "".equals(curPage))
			curPage = "1";
		ArrayList<CourseList> list = null;
		CourseDao dao = new CourseDao();
		
		Pager pager = new Pager();
		pager.setCurPage(Integer.parseInt(curPage));
		try {
			list = dao.List(pager,courseId,courseName,courseCredits);
			allcourse=coursedao.List();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("courseId",courseId );
		request.setAttribute("courseName", courseName);
		request.setAttribute("courseCredits",courseCredits);
		request.setAttribute("allcourse", allcourse);
		request.setAttribute("pager", pager);
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin_CourseList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

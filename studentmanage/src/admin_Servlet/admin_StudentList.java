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
import admin_Dao.StudentDao;
import bean.Acdemy;
import bean.StudentList;
import util.Pager;

/**
 * Servlet implementation class StudentList
 */
@WebServlet("/StudentList")
public class admin_StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_StudentList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentId=request.getParameter("studentId");
		String classId=request.getParameter("classId");
		String acdemyId=request.getParameter("acdemyId");
		String curPage = request.getParameter("cur_page");
		if (curPage == null || "".equals(curPage))
			curPage = "1";
		ArrayList<StudentList> list = null;
		StudentDao dao = new StudentDao();
		
		ArrayList<Acdemy> list1 = null;
		AcdemyDao dao1 = new AcdemyDao();
	
		
		Pager pager = new Pager();
		pager.setCurPage(Integer.parseInt(curPage));
		try {
			list =dao.List(pager,studentId,classId,acdemyId);
			list1 = dao1.List();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("acdemyList", list1);
		request.setAttribute("studentId", studentId);
		request.setAttribute("classId", classId);
		request.setAttribute("acdemyId", acdemyId);
		request.setAttribute("pager", pager);
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin_StudentList.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
import util.Pager;

/**
 * Servlet implementation class TeacherList
 */
@WebServlet("/TeacherList")
public class AdminTeacherList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTeacherList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String teacherId = request.getParameter("id");
		String teacherName = request.getParameter("name");
		String acdemyId = request.getParameter("acdemyId");
		String curPage = request.getParameter("cur_page");
		if (curPage == null || "".equals(curPage))
			curPage = "1";
		
		TeacherList bean = new TeacherList();
		if(teacherId!=null&&!"".equals(teacherId)) {
			System.out.println("teacherId:"+teacherId);
			bean.setTeacherId(Integer.parseInt(teacherId));
		}
		if(acdemyId!=null&&!"".equals(acdemyId)) {
			bean.setAcdemyId(Integer.parseInt(acdemyId));
		}
		bean.setTeacherName(teacherName);
		ArrayList<TeacherList> list = null;
		
		TeacherDao dao = new TeacherDao();
		
		ArrayList<Acdemy> list1 = null;
		AcdemyDao dao1 = new AcdemyDao();
		
		Pager pager = new Pager();
		pager.setCurPage(Integer.parseInt(curPage));
		
		try {
			list = dao.List(teacherId,teacherName,acdemyId,pager);
			list1 = dao1.List();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("acdemyId"+list1.get(1).getAcdemyId());
		request.setAttribute("pager", pager);
		request.setAttribute("list", list);
		request.setAttribute("acdemyList", list1);
		request.setAttribute("teacher", bean);
		
		request.getRequestDispatcher("admin_TeacherList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package admin_Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin_Dao.ClassDao;
import admin_Dao.CourseDao;
import admin_Dao.TimetableDao;
import bean.Classes;
import bean.CourseList;
import bean.Timetable;

/**
 * Servlet implementation class admin_TimetableList
 */
@WebServlet("/admin_TimetableList")
public class admin_TimetableList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_TimetableList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<Integer> allweek = new ArrayList<Integer>();
		ArrayList<CourseList> allcourse = null;
		CourseDao coursedao = new CourseDao();
		for(int i=1;i<=20;i++) {
			allweek.add(i);
		}
		ArrayList<Classes> allclass = new ArrayList<Classes>();
		ClassDao dao1 = new ClassDao();
		
		String teacherId = request.getParameter("teacherid");
		String courseId = request.getParameter("courseId");
		String weeks = request.getParameter("week");
		
		System.out.println(teacherId+":"+courseId+":"+weeks);
		Timetable table = new Timetable();
		if(teacherId!=null&&!"".equals(teacherId)) {
			table.setTeacherId(Integer.parseInt(teacherId));
		}
		if(courseId!=null&&!"".equals(courseId)) {
			table.setCourseId(Integer.parseInt(courseId));
		}
		if(weeks!=null&&!"".equals(weeks)) {
			table.setWeeks(weeks);
		}
		
		List<ArrayList<Timetable>> list=null;
		TimetableDao dao = new TimetableDao();
		
		try {
			list=dao.TimeTableList(table);
			allclass=dao1.Classlist();
			allcourse=coursedao.List();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("as");
		if(list!=null) {
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<list.get(i).size();j++) {
				System.out.println(i);
				System.out.println(list.get(i).get(j).toString());
			}
		}
		}
		request.setAttribute("teacherId", teacherId);
		request.setAttribute("courseId", courseId);
		request.setAttribute("week", weeks);
		
		for(int i=0;i<allclass.size();i++) {
			System.out.println(allclass.get(i).getClazz());
		}
		request.setAttribute("allclass", allclass);
		request.setAttribute("allweek", allweek);
		request.setAttribute("list", list);
		request.setAttribute("allcourse", allcourse);
		request.getRequestDispatcher("TimetableList.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
}

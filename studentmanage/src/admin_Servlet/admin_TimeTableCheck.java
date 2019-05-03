package admin_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin_Dao.TimetableDao;
import bean.Timetable;

/**
 * Servlet implementation class admin_TimeTableCheck
 */
@WebServlet("/admin_TimeTableCheck")
public class admin_TimeTableCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_TimeTableCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String teacherId = request.getParameter("teacherId");
		String weeks = request.getParameter("weeks");
		String times = request.getParameter("times");
		String weekdays = request.getParameter("weekdays");
		
		Timetable table = new Timetable();
		table.setTeacherId(Integer.parseInt(teacherId));
		table.setWeekes(Integer.parseInt(weeks));
		table.setWeekdays(Integer.parseInt(weekdays));
		table.setTimes(Integer.parseInt(times));
		
		
		Timetable table1 = null;
		
		TimetableDao dao = new TimetableDao();
		
		try {
			table1=dao.check(table);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		System.out.println("as:"+table1.getTeacherId());
		
		if (table1.getTeacherId()==0 ) {		
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"该课表不存在！\");");
			out.println("window.history.go(-1);");
			out.println("</script>");
		} else{
			request.setAttribute("oldTimetable", table1);
			request.getRequestDispatcher("admin_TimeTableEdit.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

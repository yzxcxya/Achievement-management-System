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
 * Servlet implementation class admin_TimeTableEditdo
 */
@WebServlet("/admin_TimeTableEditdo")
public class admin_TimeTableEditdo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_TimeTableEditdo() {
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
		
		String weeks1 = request.getParameter("newWeeks");
		String times1 = request.getParameter("newTimes");
		String weekdays1 = request.getParameter("newWeekdays");
		String address = request.getParameter("address");
		System.out.println("address"+address);
		
		Timetable table1 = new Timetable();
		
		System.out.println("  "+weeks1);
		table.setTeacherId(Integer.parseInt(teacherId));
		table1.setWeekes(Integer.parseInt(weeks1));
		table1.setWeekdays(Integer.parseInt(weekdays1));
		table1.setTimes(Integer.parseInt(times1));
		table1.setAddress(address);
		
		int result=0;
		TimetableDao dao = new TimetableDao();
		
		try {
			result = dao.updata(table1, table);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (result >0) {		
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"数据修改成功！\");");
			out.println("window.history.go(-1);");
			out.println("</script>");
		} else if(result==-1){
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"您有课！\");");
			out.println("window.history.go(-1);;");
			out.println("</script>");
		}else if(result==-2){
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"其他老师有课！\");");
			out.println("window.history.go(-1);;");
			out.println("</script>");
		}else if(result==-3){
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"该班有课！\");");
			out.println("window.history.go(-1);;");
			out.println("</script>");
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

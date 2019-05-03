package admin_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin_Dao.TimetableDao;
import bean.Timetable;

/**
 * Servlet implementation class admin_TimeTableDelete
 */
@WebServlet("/admin_TimeTableDelete")
public class admin_TimeTableDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_TimeTableDelete() {
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
		String weeks = request.getParameter("weekes");
		String times = request.getParameter("times");
		String weekdays = request.getParameter("weekdays");
		
		Timetable table = new Timetable();
		table.setTeacherId(Integer.parseInt(teacherId));
		table.setWeekes(Integer.parseInt(weeks));
		table.setWeekdays(Integer.parseInt(weekdays));
		table.setTimes(Integer.parseInt(times));
		
		String[] str=weeks.split(",");
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i=0;i<str.length;i++) {
			System.out.println("i"+str[i]);
			array.add(Integer.parseInt(str[i]));
		}
		
		if(array.size()>1) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"请选择具体的某一周！\");");
			out.println("window.history.go(-1)");
			out.println("</script>");
		}else {
		
		TimetableDao dao = new TimetableDao();
		int result=0;
		
		try {
			result=dao.delete(table);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (result >0) {		
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"数据删除成功！\");");
			out.println("window.history.go(-1);");
			out.println("</script>");
		}else if(result==-2){
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"请选择具体的周次！\");");
			out.println("window.history.go(-1);;");
			out.println("</script>");
		}else {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"删除失败！\");");
			out.println("window.history.go(-1);;");
			out.println("</script>");
		}
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

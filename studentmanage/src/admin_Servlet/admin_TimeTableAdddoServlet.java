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
import util.StringUtil;

/**
 * Servlet implementation class admin_TimeTableEditdoServlet
 */
@WebServlet("/admin_TimeTableAdddoServlet")
public class admin_TimeTableAdddoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_TimeTableAdddoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String teacherId = request.getParameter("teacherId");
		String courseId = request.getParameter("courseId");
		String classId = request.getParameter("classId");
		int beginweeks = Integer.parseInt(request.getParameter("week1"));
		int endweeks = Integer.parseInt(request.getParameter("week2"));
		String times = request.getParameter("times");
		String address = StringUtil.toCN(request.getParameter("address"));
		String weekdays = request.getParameter("weekdays");
		
		int result=1;
		Timetable table = new Timetable();
		table.setTeacherId(Integer.parseInt(teacherId));
		table.setCourseId(Integer.parseInt(courseId));
		table.setClassId(Integer.parseInt(classId));
		table.setWeekdays(Integer.parseInt(weekdays));
		table.setTimes(Integer.parseInt(times));
		table.setAddress(address);
		TimetableDao dao = new TimetableDao();
		System.out.println("-------------");
		for(int i=beginweeks;i<= endweeks;i++) {	
			table.setWeekes(i);
			System.out.println(table.toString());
			
			try {
				result = dao.checkclash(table);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result<0) {
				break;
			}
		
		}
		System.out.println("-------------");
		
		if(result>0) {
			for(int i=beginweeks;i<= endweeks;i++) {
				table.setWeekes(i);
				System.out.println(table.toString());
				try {
					result = dao.add(table);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(result==0) {
					break;
				}
				
			}
			System.out.println("-------------");
			if(result>0) {
				out.println("<script type='text/javascript'>");
				out.println("window.alert(\"数据添加成功！\");");
				out.println("window.history.go(-1);");
				out.println("</script>");
			}else {
				out.println("<script type='text/javascript'>");
				out.println("window.alert(\"数据添加失败！\");");
				out.println("window.history.go(-1);");
				out.println("</script>");
			}
		}else {
			if(result==-1){
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
		
	}

}

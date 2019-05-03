package admin_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Timetable;

/**
 * Servlet implementation class admin_TimeTableEdit
 */
@WebServlet("/admin_TimeTableEdit")
public class admin_TimeTableEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_TimeTableEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String teacher = request.getParameter("id");
		String weeks = request.getParameter("weeks");
		String weekdays = request.getParameter("weekdays");
		String times = request.getParameter("times");
		String address = request.getParameter("address");
		
		Timetable table = new Timetable();
		table.setTeacherId(Integer.parseInt(teacher));
		table.setWeeks(weeks);
		table.setWeekdays(Integer.parseInt(weekdays));
		table.setTimes(Integer.parseInt(times));
		table.setAddress(address);
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
		request.setAttribute("weeks", array);
		request.setAttribute("table", table);
		request.getRequestDispatcher("admin_TimeTableCheck.jsp").forward(request, response);
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

package admin_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin_Dao.AcdemyDao;
import admin_Dao.CourseDao;
import bean.Acdemy;
import bean.CourseList;

/**
 * Servlet implementation class admin_CourseEditdo
 */
@WebServlet("/admin_CourseEditdo")
public class admin_CourseEditdo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_CourseEditdo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String courseId = request.getParameter("courseId");
		String courseName = request.getParameter("courseName");
		String courseProperty = request.getParameter("courseProperty");
		String courseWay = request.getParameter("courseWay");
		String courseCredit = request.getParameter("courseCredit");
		System.out.println("acdemyId:"+courseId);
		
		CourseList bean = new CourseList();
		
		bean.setCourseId(Integer.parseInt(courseId));
		bean.setCourseName(courseName);
		bean.setCourseProperty(courseProperty);
		bean.setCourseWay(courseWay);
		bean.setCourseCredit(Integer.parseInt(courseCredit));
		
		CourseDao dao = new CourseDao();
		int result=0;
		
		try {
			result = dao.updata(bean,courseId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//PrintWriter out1 = response.setContentType("text/html;charset=utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (result > 0) {		
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"数据添加成功！\");");
			out.println("window.history.go(-1)");
			out.println("</script>");
		} else {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"数据添加出错！\");");
			out.println("window.location.href='teacherEdit?id="+courseId+"';");
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

package admin_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin_Dao.AcdemyDao;
import admin_Dao.CourseDao;

/**
 * Servlet implementation class admin_CourseAdd
 */
@WebServlet("/admin_CourseAdd")
public class admin_CourseAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_CourseAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String courseId = request.getParameter("courseId");
		String courseName = request.getParameter("courseName");
		String courseProperty=request.getParameter("courseProperty");
		String courseWay = request.getParameter("courseWay");
		String courseCredit = request.getParameter("courseCredit");
		int id = 0,result=0;
		if(courseId!=null&&!"".equals(courseId)) {
			id = Integer.parseInt(courseId);
		}
		
		CourseDao dao = new CourseDao();
		
		try {
			result= dao.add(id, courseName,courseProperty,courseWay,Integer.parseInt(courseCredit));
		} catch (Exception ex) {
			ex.printStackTrace();
			result = -1;
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (result > 0) {
			
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"数据添加成功！\");");
			out.println("window.history.back(-1);");
			out.println("</script>");
		} else {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"数据添加出错！\");");
			out.println("window.history.back(-1);");
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

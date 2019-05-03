package admin_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacher_Dao.gradeBean;
import teacher_Dao.gradeDao;

/**
 * Servlet implementation class StudentGradeEditDoServlet
 */
//@WebServlet("/StudentGradeEditDoServlet")
public class StudentGradeEditDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentGradeEditDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String studentId = request.getParameter("studentId");
		String courseId = request.getParameter("courseId");
		String grade = request.getParameter("grade");
		
		gradeBean bean = new gradeBean();
		bean.setStudentId(Integer.parseInt(studentId));
		bean.setCourseId(Integer.parseInt(courseId));
		bean.setGrade(Integer.parseInt(grade));
		int result=0;
		gradeDao dao = new gradeDao();
		
		try {
			result = dao.update(bean);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			out.println("window.location.href='admin_gradeEdit?id="+studentId+"';");
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

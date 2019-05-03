package admin_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin_Dao.TeacherDao;
import bean.TeacherList;

/**
 * Servlet implementation class TeacherAdd
 */
//@WebServlet("/TeacherAdd")
public class TeacherAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherAdd() {
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
		String teacherName = request.getParameter("teacherName");
		String password = request.getParameter("password");
		String acdemyId = request.getParameter("acdemyId");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		
		TeacherList teacher = new TeacherList();
		teacher.setTeacherId(Integer.parseInt(teacherId));
		teacher.setTeacherName(teacherName);
		teacher.setPasword(password);
		teacher.setAcdemyId(Integer.parseInt(acdemyId));
		teacher.setSex(sex);
		teacher.setTel(tel);
		teacher.setAddress(address);
		
		TeacherDao dao =new TeacherDao();
		int result = 0;
		
		try {
			result = dao.insert(teacher);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (result > 0) {		
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"数据添加成功！\");");
			//out.println("window.location.href='teacherList';");
			out.println("window.history.go(-1);");
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

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
import util.StringUtil;

/**
 * Servlet implementation class TeacherEditDo
 */
@WebServlet("/TeacherEditDo")
public class TeacherEditDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherEditDo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String id = request.getParameter("teacherId");
		String teacherName = request.getParameter("teacherName");
		String tel = request.getParameter("tel");
		String acdemyId = request.getParameter("acdemy");
		String address = request.getParameter("address");
		
		System.out.println("teachereditdo1:"+teacherName);
		System.out.println("teachereditdo2:"+request.getParameter("teacherName"));
		TeacherList list = new TeacherList();
		list.setTeacherId(Integer.parseInt(id));
		list.setTeacherName(teacherName);
		list.setTel(tel);
		list.setAcdemyId(Integer.parseInt(acdemyId));
		list.setAddress(address);
		
		int result = 0;
		TeacherDao dao = new TeacherDao();
		
		try {
			result = dao.update(list);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
			out.println("window.location.href='admin_teacherEdit?id="+id+"';");
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

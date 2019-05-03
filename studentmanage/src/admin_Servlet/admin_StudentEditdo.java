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
import admin_Dao.StudentDao;
import bean.Acdemy;
import bean.StudentList;

/**
 * Servlet implementation class admin_StudentEditdo
 */
@WebServlet("/admin_StudentEditdo")
public class admin_StudentEditdo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_StudentEditdo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentId = request.getParameter("id");
		String studentName = request.getParameter("studentName");
		String acdemyId = request.getParameter("acdemyId");
		String classId = request.getParameter("classId");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String nation = request.getParameter("nation");
		String tel = request.getParameter("tel");
		System.out.println("acdemyId:"+acdemyId);
		
		StudentList bean = new StudentList();
		
		bean.setAcdemyId(Integer.parseInt(acdemyId));
		bean.setStudentName(studentName);
		bean.setSex(sex);
		bean.setNation(nation);
		bean.setTel(tel);
		bean.setAddress(address);
		bean.setClassId(Integer.parseInt(classId));
		bean.setStudentId(Integer.parseInt(studentId));
		
		StudentDao dao = new StudentDao();
		int result=0;
		
		try {
			result = dao.updata(bean,studentId);
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
			out.println("window.location.href='teacherEdit?id="+studentId+"';");
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

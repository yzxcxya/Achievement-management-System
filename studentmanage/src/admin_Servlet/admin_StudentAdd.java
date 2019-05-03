package admin_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin_Dao.StudentDao;
import bean.StudentList;

/**
 * Servlet implementation class admin_StudentAdd
 */
@WebServlet("/admin_StudentAdd")
public class admin_StudentAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_StudentAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String StudentId = request.getParameter("studentId");
		String studentName = request.getParameter("studentName");
		String classId = request.getParameter("classId");
		System.out.println(classId);
		String acdemyId = request.getParameter("acdemyId");
		System.out.println(acdemyId);
		String sex = request.getParameter("sex");
		String tel = request.getParameter("tel");
		String nation = request.getParameter("nation");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String admissiontime = request.getParameter("admissiontime");
		String image = request.getParameter("image");
		int id = 0,result=0;
		if(acdemyId!=null&&!"".equals(acdemyId)) {
			id = Integer.parseInt(StudentId);
		}
		
		StudentDao dao = new StudentDao();
		
		try {
		
			result= dao.add(id, studentName,password,sex,nation,Integer.parseInt(classId),Integer.parseInt(acdemyId),tel,admissiontime,address,image);
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

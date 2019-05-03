package teacher_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Teacher;
import teacher_Dao.teacherDao;

public class TeacherInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TeacherInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teacherId = request.getSession().getAttribute("TeacherId").toString();
		String tel = request.getParameter("tel");
		String password = request.getParameter("password");
		String address = new String(request.getParameter("address").getBytes("ISO8859-1"),"utf-8");
		String sex = new String(request.getParameter("sex").getBytes("ISO8859-1"),"utf-8");
		String nation = new String(request.getParameter("nation").getBytes("ISO8859-1"),"utf-8");
		System.out.println("a"+address);
		System.out.println("b"+nation);
		Teacher tec = new Teacher();
		tec.setTel(tel);
		tec.setAddress(address);
		tec.setPassword(password);
		tec.setSex(sex);
		tec.setNation(nation);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
	    try {
	    	if(teacherDao.TeacherInfoEdit(tec,teacherId)) {
	    		out.println("<script type='text/javascript'>");
				out.println("window.alert(\"教师信息修改成功\");");
				out.println("window.location.href='teacher-edit.jsp';");
				out.println("</script>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

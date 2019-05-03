package StudentServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import StudentDao.StudentDao;
import bean.Student;

public class StuInfoEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public StuInfoEditServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = (Student) request.getSession().getAttribute("stu");
		System.out.println("原密码"+student.getPassword());
		String originalPassword2 = request.getParameter("originalPassword");
		String newPassword = request.getParameter("newPassword1");
		String StuId = request.getSession().getAttribute("StuId").toString();
		if(!student.getPassword().equals(originalPassword2)) {
			request.getRequestDispatcher("StuInfoEdit.jsp?f=1").forward(request, response);
		}else {
			int result = 0;
			try {
				result = StudentDao.editInfo(StuId,newPassword);
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
				out.println("window.alert(\"密码修改成功！\");");
				out.println("window.location.href='StuInfoEdit.jsp';");
				out.println("</script>");
			} else {
				out.println("<script type='text/javascript'>");
				out.println("window.alert(\"密码修改出错！\");");
				out.println("window.location.href='StuInfoEdit.jsp';");
				out.println("</script>");
			}
		}
	}

}

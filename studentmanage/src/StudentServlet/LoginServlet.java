package StudentServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import StudentDao.LoginDao;
import StudentDao.StudentDao;
import bean.Grade;
import bean.Student;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String StuId = request.getParameter("StuId");
		String StuPassword = request.getParameter("StuPassword");
		String remember= request.getParameter("remember");
		String code = request.getParameter("code1");
		String codeImage = request.getSession().getAttribute("rCode").toString();
		Student stu = new Student();
		stu.setId(StuId);
		stu.setPassword(StuPassword);
		if(code.equals(codeImage)) {
			try {
				if(LoginDao.checkStu(stu)==0) {
					if (remember!=null) {
						Cookie c1 = new Cookie("StuId", StuId);
						Cookie c2 = new Cookie("StuPassword", StuPassword);
						c1.setMaxAge(1000);
						c2.setMaxAge(1000);//这里设置保存这条Cookie的时间
						response.addCookie(c1);//添加Cookie
						response.addCookie(c2);
						
					}
					Student student = StudentDao.StudentInfo(stu.getId());
					//List<Grade> list = StudentDao.GradeInfo(stu.getId());
					request.getSession().setAttribute("stu", student);
					//this.getServletContext().setAttribute("stu", student);
					//request.setAttribute("grade", list);
					request.getSession().setAttribute("StuId", StuId);
					request.getRequestDispatcher("StuIndex.jsp").forward(request, response);
				}
				else if(LoginDao.checkStu(stu)==1) {
					request.getRequestDispatcher("Login.jsp?f=1").forward(request, response);
				}
				else if(LoginDao.checkStu(stu)==2) {
					request.getRequestDispatcher("Login.jsp?f=2").forward(request, response);
				}
				else if(LoginDao.checkStu(stu)==3) {
					request.getRequestDispatcher("Login.jsp?f=3").forward(request, response);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			request.getRequestDispatcher("Login.jsp?f=4").forward(request, response);
		}
	}

}

package StudentServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import StudentDao.LoginDao;
import bean.Student;
import bean.Teacher;
import teacher_Dao.teacherDao;
public class TeacherLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String TeacherId = request.getParameter("TeacherId");
		String TeacherPassword = request.getParameter("TeacherPassword");
		String remember= request.getParameter("TeacherRemember");
		String code = request.getParameter("code2");
		String codeImage = request.getSession().getAttribute("rCode").toString();
		Teacher tec = new Teacher();
		tec.setId(TeacherId);
		tec.setPassword(TeacherPassword);
		if(code.equals(codeImage)) {
			try {
				if(LoginDao.checkTec(tec)==0) {
					if (remember!=null) {
						Cookie c3 = new Cookie("TeacherId", TeacherId);
						Cookie c4 = new Cookie("TeacherPassword", TeacherPassword);
						c3.setMaxAge(1000);
						c4.setMaxAge(1000);//�������ñ�������Cookie��ʱ��
						response.addCookie(c3);//���Cookie
						response.addCookie(c4);
						
					}
					Teacher teacher = teacherDao.TeacherInfo(tec.getId());
					request.getSession().setAttribute("teacher", teacher);
					request.getSession().setAttribute("TeacherId", TeacherId);
					request.getRequestDispatcher("teacher_index.jsp").forward(request, response);
				}
				else if(LoginDao.checkTec(tec)==1) {
					request.getRequestDispatcher("Login.jsp?g=1").forward(request, response);
				}
				else if(LoginDao.checkTec(tec)==2) {
					request.getRequestDispatcher("Login.jsp?g=2").forward(request, response);
				}
				else if(LoginDao.checkTec(tec)==3) {
					request.getRequestDispatcher("Login.jsp?g=3").forward(request, response);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			request.getRequestDispatcher("Login.jsp?g=4").forward(request, response);
		}
	}

}

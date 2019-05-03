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
import admin_Dao.adminDao;
import bean.Admin;
import bean.Teacher;

public class AdmLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String AdminId = request.getParameter("AdminId");
		String AdminPassword = request.getParameter("AdminPassword");
		String remember= request.getParameter("AdminRemember");
		String code = request.getParameter("code3");
		String codeImage = request.getSession().getAttribute("rCode").toString();
		Admin adm = new Admin();
		adm.setId(AdminId);
		adm.setPassword(AdminPassword);
		if(code.equals(codeImage)) {
			try {
				if(LoginDao.checkAdm(adm)==0) {
					if (remember!=null) {
						Cookie c5 = new Cookie("AdminId", AdminId);
						Cookie c6 = new Cookie("AdminPassword", AdminPassword);
						c5.setMaxAge(1000);
						c6.setMaxAge(1000);//�������ñ�������Cookie��ʱ��
						response.addCookie(c5);//���Cookie
						response.addCookie(c6);
						
					}
					Admin admin = adminDao.AdminInfo(adm.getId());
					request.getSession().setAttribute("admin", admin);
					request.getSession().setAttribute("AdminId", AdminId);
					request.getRequestDispatcher("admin_index.jsp").forward(request, response);
				}
				else if(LoginDao.checkAdm(adm)==1) {
					request.getRequestDispatcher("Login.jsp?h=1").forward(request, response);
				}
				else if(LoginDao.checkAdm(adm)==2) {
					request.getRequestDispatcher("Login.jsp?h=2").forward(request, response);
				}
				else if(LoginDao.checkAdm(adm)==3) {
					request.getRequestDispatcher("Login.jsp?h=3").forward(request, response);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			request.getRequestDispatcher("Login.jsp?h=4").forward(request, response);
		}
	}

}

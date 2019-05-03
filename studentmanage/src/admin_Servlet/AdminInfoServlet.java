package admin_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin_Dao.adminDao;
import bean.Admin;

public class AdminInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AdminInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String AdminId = request.getSession().getAttribute("AdminId").toString();
		String adminId = request.getParameter("adminId");
		String adminName = new String(request.getParameter("adminName").getBytes("ISO8859-1"),"utf-8");
		String tel = request.getParameter("tel");
		String password = request.getParameter("password");
		String address = new String(request.getParameter("address").getBytes("ISO8859-1"),"utf-8");
		String sex = new String(request.getParameter("sex").getBytes("ISO8859-1"),"utf-8");
		Admin admin = new Admin();
		admin.setId(adminId);
		admin.setName(adminName);
		admin.setTel(tel);
		admin.setAddress(address);
		admin.setPassword(password);
		admin.setSex(sex);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
	    try {
	    	if(adminDao.AdminInfoEdit(admin,AdminId)) {
	    		out.println("<script type='text/javascript'>");
				out.println("window.alert(\"管理员信息修改成功\");");
				out.println("window.location.href='adminEdit.jsp';");
				out.println("</script>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

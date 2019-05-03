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

/**
 * Servlet implementation class admin_StudentDelete
 */
//@WebServlet("/admin_StudentDelete")
public class admin_StudentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_StudentDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				//response.getWriter().append("Served at: ").append(request.getContextPath());
				String id = request.getParameter("id");
				int result = 0;
				
				StudentDao dao = new StudentDao();
				try {
					result = dao.delete(id);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				
				if (result > 0) {		
					out.println("<script type='text/javascript'>");
					out.println("window.alert(\"数据删除成功！\");");
					out.println("window.history.back(-1);");
					out.println("</script>");
				} else {
					out.println("<script type='text/javascript'>");
					out.println("window.alert(\"数据删除出错！\");");
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

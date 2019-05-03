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
import bean.Acdemy;

/**
 * Servlet implementation class AcdemyEditdo
 */
//@WebServlet("/AcdemyEditdo")
public class AcdemyEditdo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcdemyEditdo() {
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
		String acdemyName = request.getParameter("acdemyName");
		String acdemyId = request.getParameter("acdemyId");
		System.out.println("acdemyId:"+acdemyId);
		
		Acdemy bean = new Acdemy();
		
		bean.setAcdemyId(Integer.parseInt(acdemyId));
		bean.setAcdemyName(acdemyName);
		
		AcdemyDao dao = new AcdemyDao();
		int result=0;
		
		try {
			result = dao.updata(bean,id);
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
			out.println("window.location.href='teacherEdit?id="+id+"';");
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

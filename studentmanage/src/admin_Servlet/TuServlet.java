package admin_Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacher_Dao.gradeBean;
import teacher_Dao.gradeDao;

/**
 * Servlet implementation class TuServlet
 */
@WebServlet("/TuServlet")
public class TuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		gradeDao Dao = new gradeDao();
		int[] all=new int[6];
		try {
			 all =Dao.Allnum();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		int a = all[0];
		int b = all[1];
		int c = all[2];
		int a1=all[3]; 
		int a2=all[4];
		int a3=all[5];
		request.setAttribute("a", a);
		request.setAttribute("b", b);
		request.setAttribute("c", c);
		request.setAttribute("a1", a1);
		request.setAttribute("a2", a2);
		request.setAttribute("a3", a3);
		System.out.println("a"+a+"b"+b+"c"+c);
		request.getRequestDispatcher("Tu.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
 * Servlet implementation class StudentGradeEditServlet
 */
@WebServlet("/StudentGradeEditServlet")
public class StudentGradeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentGradeEditServlet() {
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
		String courseId = request.getParameter("courseId");
		System.out.println("id:"+id+" courseId:"+courseId);
		gradeBean bean = null;
		gradeDao dao = new gradeDao();
		
		try {
			bean = dao.loadGrade(Integer.parseInt(id),Integer.parseInt(courseId));
		} catch (NumberFormatException | ClassNotFoundException | InstantiationException | IllegalAccessException
				| SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("admin_StudentGradeEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

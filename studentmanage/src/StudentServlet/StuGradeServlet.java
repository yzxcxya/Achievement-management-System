package StudentServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import StudentDao.StudentDao;
import bean.Grade;

public class StuGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public StuGradeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String createTime = request.getParameter("time");
		String stuId = request.getSession().getAttribute("StuId").toString();
		List<Grade> list = null;
		double avgGrade = 0;
		double sumGrade = 0;
		try {
			avgGrade = StudentDao.avgGrade(createTime,stuId);
			sumGrade = StudentDao.sumGrade(createTime,stuId);
			list = StudentDao.GradeInfo(createTime,stuId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("avgGrade", avgGrade);
		request.setAttribute("sumGrade", sumGrade);
		request.setAttribute("time", createTime);
		request.setAttribute("list", list);
		request.getRequestDispatcher("StudentRight.jsp").forward(request, response);
	}


}

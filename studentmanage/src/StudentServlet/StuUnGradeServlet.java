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

public class StuUnGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public StuUnGradeServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stuId = request.getSession().getAttribute("StuId").toString();
		List<Grade> listUngrade = null;
		int totalCredit = 0;
		try {
			listUngrade = StudentDao.UnGradeInfo(stuId);
			totalCredit = StudentDao.UnGradeTotalCredit(stuId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("totalCredit", totalCredit);
		request.setAttribute("listUngrade", listUngrade);
		request.getRequestDispatcher("StudentRight.jsp").forward(request, response);
	}

}

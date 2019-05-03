package admin_Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacher_Dao.gradeBean;
import teacher_Dao.gradeDao;
import util.Pager;

/**
 * Servlet implementation class StudentGradeList
 */
@WebServlet("/StudentGradeList")
public class StudentGradeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentGradeList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentId = request.getParameter("studentId");  // �������������š�
		String courseId = request.getParameter("courseId");  // ���������⡱
		String createTime = request.getParameter("createtime");
		String curPage = request.getParameter("cur_page");
		System.out.println("studnet:"+studentId);
		if (curPage == null || "".equals(curPage))
			curPage = "1";
		gradeDao dao = new gradeDao();
		List<gradeBean> list = null;
		Pager pager = new Pager();
		pager.setCurPage(Integer.parseInt(curPage));
		try {
			list = dao.listFile(studentId,courseId, createTime, pager);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		request.setAttribute("studentId", studentId);
		request.setAttribute("createTime", createTime);
		request.setAttribute("courseId", courseId);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		request.getRequestDispatcher("admin_StudentGradeList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

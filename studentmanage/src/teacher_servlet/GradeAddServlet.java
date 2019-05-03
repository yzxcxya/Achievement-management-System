package teacher_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;

import teacher_Dao.gradeBean;
import teacher_Dao.gradeDao;
import util.StringUtil;



/**
 * Servlet implementation class GradeAddServlet
 */
@WebServlet("/GradeAddServlet")
public class GradeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		gradeBean bean = new gradeBean();
		int studentId=Integer.parseInt(StringUtil.toCN(request.getParameter("studentId")));
		int courseId=Integer.parseInt(StringUtil.toCN(request.getParameter("courseId")));
		int grade=Integer.parseInt(StringUtil.toCN(request.getParameter("grade")));
		String createtime=StringUtil.toCN(request.getParameter("createtime").toString());
		bean.setGrade(grade);
		System.out.println(bean.getGrade());
		bean.setCourseId(courseId);
		System.out.println(bean.getCourseId());
		bean.setStudentId(studentId);
		System.out.println(bean.getStudentId());
		bean.setCreatetime(createtime);
		System.out.println(bean.getCreatetime());
		gradeDao dao = new gradeDao();
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			if (dao.add(bean) > 0) {		
				out.println("<script type='text/javascript'>");
				out.println("window.alert(\"数据添加成功！\");");
				out.println("window.history.go(-2)");
				out.println("</script>");
			} else {
				out.println("<script type='text/javascript'>");
				out.println("window.alert(\"数据添加出错！\");");
				out.println("window.location.back(-1)';");
				out.println("</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("222222");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

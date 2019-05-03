package admin_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import admin_Dao.StudentDao;
import bean.Student;
import util.DateUtil;

/**
 * Servlet implementation class admin_StudentImageEdit
 */
@WebServlet("/admin_StudentImageEdit")
public class admin_StudentImageEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_StudentImageEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServletConfig(), request, response);
		su.setAllowedFilesList("gif,png,jpg");
		su.setCharset("utf-8");
		
		try {
			su.upload();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		
		Student bean = new Student();
		bean.setId(su.getRequest().getParameter("id"));
		
		File file = su.getFiles().getFile(0);
		String fileName = file.getFileName();
		fileName =DateUtil.GetTodayStr()+fileName;
		System.out.println("filetype:"+file.getFileExt());
		System.out.println("filename:"+fileName);
		try {
			file.saveAs("/image/" + fileName);
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		bean.setImage(fileName);
		
		StudentDao dao = new StudentDao();
		int result=0;
		
		try {
			result = dao.editImage(bean);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (result > 0) {		
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"数据添加成功！\");");
			out.println("window.history.go(-2)");
			out.println("</script>");
		} else {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"数据添加出错！\");");
			out.println("window.history.go(-1)");
			out.println("</script>");
		}
		
	}

}

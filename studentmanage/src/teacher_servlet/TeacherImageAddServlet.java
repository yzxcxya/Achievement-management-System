package teacher_servlet;

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

import StudentDao.StudentDao;
import Utils.DateUtil;
import bean.Student;
import bean.Teacher;
import teacher_Dao.teacherDao;

public class TeacherImageAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public TeacherImageAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServletConfig(), request, response);
		su.setAllowedFilesList("gif,png,jpg");
		su.setCharset("utf-8");
		
		try {
			su.upload();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		
		Teacher teacher = new Teacher();
		teacher.setId(su.getRequest().getParameter("id"));
		
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
		teacher.setImage(fileName);
		
		teacherDao dao = new teacherDao();
		int result=0;
		
		try {
			result = dao.addImage(teacher);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (result > 0) {		
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"图片修改成功！\");");
			out.println("window.history.go(-2);");
			out.println("</script>");
		} else {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"图片修改失败！\");");
			out.println("window.history.go(-1)");
			out.println("</script>");
		}
	}

}

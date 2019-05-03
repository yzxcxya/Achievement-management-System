package StudentServlet;

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

public class ImageAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ImageAddServlet() {
        super();
       
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
		
		Student stu = new Student();
		stu.setId(su.getRequest().getParameter("id"));
		
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
		stu.setImage(fileName);
		
		StudentDao dao = new StudentDao();
		int result=0;
		
		try {
			result = dao.addImage(stu);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (result > 0) {		
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"数据添加成功！\");");
			out.println("window.history.go(-2);");
			out.println("</script>");
		} else {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"数据添加失败！\");");
			out.println("window.history.go(-1)");
			out.println("</script>");
		}
	}

}

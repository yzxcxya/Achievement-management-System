package teacher_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import teacher_Dao.excelbean;





/**
 * Servlet implementation class Xlsadd
 */
@WebServlet("/Xlsadd")
public class Xlsadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Xlsadd() {
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
		excelbean bean = new excelbean();
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServletConfig(), request, response);
		su.setAllowedFilesList("xls");
		su.setCharset("utf-8");
		try {
			su.upload();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		File file = su.getFiles().getFile(0);
		String dizhi="";
		try {
			file.saveAs("D:\\" + file.getFileName());
			dizhi="D:\\" + file.getFileName();
			System.out.println(dizhi);
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		 bean.setDizhi(dizhi);
		// TODO Auto-generated method stub
		request.setAttribute("dizhi", dizhi);
		 request.getRequestDispatcher("test.jsp").forward(request, response);
		doGet(request, response);
	}

}

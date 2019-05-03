package teacher_servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import teacher_Dao.gradeBean;
import teacher_Dao.gradeDao;

/**
 * Servlet implementation class DownGrade
 */
//@WebServlet("/DownGrade")
public class DownGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownGrade() {
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
		@SuppressWarnings("resource")
		String studentId=request.getParameter("studentId");
		String courseId=request.getParameter("courseId");
		String createtime = request.getParameter("createtime");
		System.out.
		println("grade down"+studentId+"aa"+courseId);
		int a=0;
		gradeBean bean=new gradeBean();
		gradeDao dao =new gradeDao();
		HSSFWorkbook wb = new HSSFWorkbook();
		try {
			bean=dao.loadGrade(a);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<gradeBean> list =null;
		try {
			list=dao.listResult(studentId,courseId,createtime);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int z=list.size();
		Object[][] datas = new Object[z+1][4];
		datas[0][0]="学号";
		datas[0][1]="课程号";
		datas[0][2]="成绩";
		datas[0][3]="学期";
		HSSFSheet sheet = wb.createSheet("table");  //创建table工作薄
		for(int i=1;i<list.size()+1;i++){
			System.out.println("size"+list.size());
			
				
				
				 datas[i][0]=list.get(i-1).getStudentId();
				//System.out.println("数组1"+datas[i][0].toString());
					datas[i][1]=list.get(i-1).getCourseId();
					System.out.println(datas[i][1].toString());
					datas[i][2]=list.get(i-1).getGrade();
					System.out.println(datas[i][2].toString());
					datas[i][3]=list.get(i-1).getCreatetime();
					System.out.println(datas[i][3].toString());
				
			
		}
		//Object[][] datas = {{bean.getStudentId() ,bean.getCourseId(),  bean.getGrade(),bean.getCreatetime()}};
		Object[] datas2=list.toArray();
		
	
		HSSFRow row;
		HSSFCell cell;
		for(int i = 0; i < datas.length; i++) {
		    row = sheet.createRow(i);//创建表格行
		    for(int j = 0; j < datas[i].length; j++) {
		        cell = row.createCell(j);//根据表格行创建单元格
		        cell.setCellValue(String.valueOf(datas[i][j]));
		    }
		}
		   ByteArrayOutputStream os = new ByteArrayOutputStream();
		   wb.write(os);
		   byte[] content = os.toByteArray();
		   InputStream is = new ByteArrayInputStream(content);
		   response.reset();
		   response.setContentType("application/vnd.ms-excel;charset=utf-8");
		   response.setHeader("Content-Disposition", "attachment;filename=table.xls");
		   
		   ServletOutputStream out = response.getOutputStream();
		      BufferedInputStream bis = null;
		      BufferedOutputStream bos = null;
		 
		      try {
		        bis = new BufferedInputStream(is);
		        bos = new BufferedOutputStream(out);
		        byte[] buff = new byte[2048];
		        int bytesRead;
		        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
		          bos.write(buff, 0, bytesRead);
		        }
		      } catch (Exception e) {
		        e.printStackTrace();
		      } finally {
		        if (bis != null)
		          bis.close();
		        if (bos != null)
		          bos.close();
		      }
		wb.write(new FileOutputStream("D:/execltest/table.xls"));
	}

}

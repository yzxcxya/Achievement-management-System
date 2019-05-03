package teacher_servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacher_Dao.excelbean;
import teacher_Dao.exceldao;
import teacher_Dao.gradeDao;
import util.StringUtil;
import teacher_Dao.gradeBean;

/**
 * Servlet implementation class Xlsread
 */
@WebServlet("/Xlsread")
public class Xlsread extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Xlsread() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		excelbean bean = new excelbean();
		
		String dizhi=StringUtil.toCN(request.getParameter("filepos").toString());
		System.out.println("xlsread dizhi"+dizhi);

		exceldao dao=new exceldao();
		gradeBean bean2 = new gradeBean();
		gradeDao dao2 =new gradeDao();
		List<gradeBean> list =null;
	
		
		String test=exceldao.main(dizhi);
		 String[] tt=test.split("\\s+");
		 System.out.println(test);
	        for(String s:tt)
	        {
	            System.out.println(s);
	        }
	        try {
				//dao2.addexcel(test);
	        	list=dao2.addexcel(test);
	        	System.out.println(test+"excel biaoge neirong");
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
	        	System.out.println("是否添加");
	        	for(int i=0;i<list.size();i++){
	        		dao2.add(list.get(i));
	        		   System.out.println("是否成功 内容");
	        	}
				if (dao2.add(bean2)>0) {  // 插入数据成功
					response.sendRedirect("teacher_GradeList.jsp");
					System.out.println("111111111");
				} else {			// 插入数据失败！
					response.sendRedirect("teacher-GradeAdd.jsp");
					System.out.println("eeeeeee");	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		System.out.println("final1"+test);
		// TODO Auto-generated method stub
		
	
		request.getSession().setAttribute("test",test) ;
		request.getRequestDispatcher("teacher_GradeList.jsp").forward(request, response);
		
		 
		doGet(request, response);
	}

}

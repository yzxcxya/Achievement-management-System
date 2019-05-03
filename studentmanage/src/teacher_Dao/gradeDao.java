package teacher_Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.DBUtil;
import util.Pager;

public class gradeDao {

	public gradeBean loadGrade(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException  {
		gradeBean bean = new gradeBean();
		Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		String url = "jdbc:mysql://localhost:3306/Grade?useSSL=false";
		Connection conn = DriverManager.getConnection(url, "user", "user");
		

		if (conn != null) {
			String sql = "select * from grade,course,student where grade.courseId=course.courseId and student.studentId=grade.studentId and grade.studentId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setStudentName(rs.getString("studentName"));
				bean.setStudentId(rs.getInt("grade.studentId"));
				bean.setCourseId(rs.getInt("courseId"));
				bean.setcourseName(rs.getString("courseName"));
				bean.setGrade(rs.getInt("grade"));
				bean.setCreatetime(rs.getString("createtime"));
				
			}
			
		}
		return bean;
	}
	public int[] Allnum() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		
		Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		String url = "jdbc:mysql://localhost:3306/Grade?useSSL=false";
		Connection conn = DriverManager.getConnection(url, "user", "user");
		
							
			String sql = "select count(*) from student,grade where grade.studentId=student.studentId and grade>60";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int a = rs.getInt(1);
			
			sql = "select count(*) from student,grade where grade.studentId=student.studentId and grade>60 and sex='男'";
			 pstmt = conn.prepareStatement(sql);
			 rs = pstmt.executeQuery();
			 rs.next();
			 int b = rs.getInt(1);
			 sql = "select count(*) from student,grade where grade.studentId=student.studentId and grade>60 and sex='女'";
			 pstmt = conn.prepareStatement(sql);
			 rs = pstmt.executeQuery();
			 rs.next();
			 int c = rs.getInt(1);
			 sql = "select count(*) from student,grade where grade.studentId=student.studentId and grade>60 and classid=162013";
			pstmt = conn.prepareStatement(sql);
			 rs = pstmt.executeQuery();
				rs.next();
				int a1 = rs.getInt(1);
				
				sql = "select count(*) from student,grade where grade.studentId=student.studentId and grade>60 and classid=162011";
				 pstmt = conn.prepareStatement(sql);
				 rs = pstmt.executeQuery();
				 rs.next();
				 int a2 = rs.getInt(1);
				 sql = "select count(*) from student,grade where grade.studentId=student.studentId and grade>60 and classid=162012";
				 pstmt = conn.prepareStatement(sql);
				 rs = pstmt.executeQuery();
				 rs.next();
				 int a3 = rs.getInt(1);
				
			
			 int[] result = new int[]{a,b,c,a1,a2,a3};
			return result;
		}
	
	public gradeBean loadGrade(int id,int courseId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException  {
		gradeBean bean = new gradeBean();
		Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		String url = "jdbc:mysql://localhost:3306/Grade?useSSL=false";
		Connection conn = DriverManager.getConnection(url, "user", "user");
		

		if (conn != null) {
			String sql = "select * from grade,course,student where grade.courseId=course.courseId and student.studentId=grade.studentId and grade.studentId = ? and grade.courseId=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			pstmt.setInt(2, courseId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setStudentName(rs.getString("studentName"));
				bean.setStudentId(rs.getInt("grade.studentId"));
				bean.setCourseId(rs.getInt("courseId"));
				bean.setcourseName(rs.getString("courseName"));
				bean.setGrade(rs.getInt("grade"));
				bean.setCreatetime(rs.getString("createtime"));
				
			}
			
		}
		return bean;
	}
	
	public List<gradeBean> listResult(String studentId,String courseId,String createtime) throws SQLException {
		List<gradeBean> list = new ArrayList<gradeBean>();
		Connection conn = DBUtil.getConnection();
		if (conn != null) {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql="select * from grade where 1=1 ";
			if (courseId != null && !"".equals(courseId))
				sql += " and courseId ='" + courseId + "'";
			if (studentId != null && !"".equals(studentId))
				sql += " and studentId like '%" + studentId + "%'";
			if (createtime != null && !"".equals(createtime))
				sql += " and createtime ='" + createtime + "'";
			
			System.out.println("sql:" + sql);
			//sql += " order by is_top desc,id";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				gradeBean bean = new gradeBean();
				bean.setCourseId(rs.getInt("CourseId"));
				bean.setStudentId(rs.getInt("StudentId"));
				bean.setGrade(rs.getInt("grade"));
				bean.setCreatetime(rs.getString("createtime"));
				list.add(bean);
			}
			rs.close();
			stmt.close();
		}
		
		
		DBUtil.freeConnection(conn);
		return list;
	}
	
	public int update(gradeBean bean) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		int result = 0;
	
		Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		String url = "jdbc:mysql://localhost:3306/Grade?useSSL=false";
		Connection conn = DriverManager.getConnection(url, "user", "user");
		if (conn != null) {
							
			String sql = "update grade set grade = ? where studentId = ? and courseId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			System.out.println(sql);
			pstmt.setInt(3, bean.getCourseId());
			pstmt.setInt(1, bean.getGrade());
			pstmt.setInt(2, bean.getStudentId());
			result = pstmt.executeUpdate();
			} else {
				result = -1;
			} 
			return result;
		}
	
	public int delete(String StudentId,String CourseId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		int result = 0;
		Connection conn = DBUtil.getConnection();
		
		if (conn != null) {
			String sql = "delete from grade  where studentid = ? and courseId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(StudentId));
			pstmt.setInt(2, Integer.parseInt(CourseId));
			result = pstmt.executeUpdate();
		} else {
			result = -1;
		}
		DBUtil.freeConnection(conn);
		return result;
	}
	public List<gradeBean> listFile(int courseId, int studentId,String createtime) throws SQLException {
		List<gradeBean> list = new ArrayList<gradeBean>();
		Connection conn = DBUtil.getConnection();
		if (conn != null) {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql="select * from grade where 1=1 ";
			if (courseId != 0 && !"".equals(courseId))
				sql += " and courseId ='" + courseId + "'";
			if (studentId != 0 && !"".equals(studentId))
				sql += " and studentId like '%" + studentId + "%'";
			if (createtime != null && !"".equals(createtime))
				sql += " and createtime ='" + createtime + "'";
			System.out.println("sql:" + sql);
			//sql += " order by is_top desc,id";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				gradeBean bean = new gradeBean();
				
				bean.setGrade(rs.getInt("grade"));
				
				list.add(bean);
			}
			rs.close();
			stmt.close();
		}
		
		DBUtil.freeConnection(conn);
		return list;
	}
	public List<gradeBean> listExcel() throws SQLException {
		List<gradeBean> list = new ArrayList<gradeBean>();
		Connection conn = DBUtil.getConnection();
		if (conn != null) {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql="select * from grade where 1=1 ";
			
			System.out.println("sql:" + sql);
			//sql += " order by is_top desc,id";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				gradeBean bean = new gradeBean();
				bean.setCourseId(rs.getInt("CourseId"));
				bean.setStudentId(rs.getInt("StudentId"));
				bean.setGrade(rs.getInt("grade"));
				bean.setCreatetime(rs.getString("createtime"));
				list.add(bean);
			}
			rs.close();
			stmt.close();
		}
		
		
		DBUtil.freeConnection(conn);
		return list;
	}
	public List<gradeBean> listFile(String studentId,String courseId,String createtime,Pager pager) throws SQLException
	{
		List<gradeBean> list = new ArrayList<gradeBean>();
		Connection conn = DBUtil.getConnection();
		if (conn != null) {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql="select count(*) from grade";
			String whereSql = " where 1=1 ";
			if (studentId != null && !"".equals(studentId))
				whereSql += " and grade.studentId =" + studentId + "";
			if (createtime != null && !"".equals(createtime))
				whereSql += " and createtime like '%" + createtime + "%'";
			if (courseId != null && !"".equals(courseId))
				whereSql += " and grade.courseId like '%" + courseId + "%'";
			System.out.println("sql:" + sql+whereSql);
			//sql += " order by is_top desc,id";
			
			// �ȼ����ܼ�¼��
			ResultSet rs = stmt.executeQuery(sql + whereSql);
			int totalCount = 0;
			if (rs.next())  {
				totalCount = rs.getInt(1);
			}
			rs.close();
			pager.setTotalRecord(totalCount);
			
			//sql = " order by is_top desc,id";
			sql = "select * from grade,student,course ";
			
			sql+=whereSql;
			sql += " and student.studentId = grade.studentId and grade.courseId = course.courseId limit "+ (pager.getCurPage()-1) * pager.getPageSize()+",5";
			
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				gradeBean bean = new gradeBean();
				bean.setStudentId(rs.getInt("student.Studentid"));
				bean.setCourseId(rs.getInt("course.courseid"));
				bean.setGrade(rs.getInt("grade"));
				bean.setCreatetime(rs.getString("createtime"));
				bean.setcourseName(rs.getString("courseName"));
				bean.setStudentName(rs.getString("studentName"));
				
				list.add(bean);
			}
			rs.close();
			stmt.close();
		}
		return list;
	}
	
	public int add(gradeBean bean) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		int result = 0;
		Connection conn = DBUtil.getConnection();
		System.out.println("gggg");
		
		if (conn != null) {
			String sql = "insert into grade(studentid, courseid, grade,createtime) values (?, ?, ?,?)";
			System.out.println(sql);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getStudentId());
			pstmt.setInt(2, bean.getCourseId());
			pstmt.setInt(3, bean.getGrade());
			pstmt.setString(4, bean.getCreatetime());
			System.out.println(sql);
			result = pstmt.executeUpdate();
			System.out.println(result);
			//System.out.println("result:" + result);
		} else {
			result = -1;
		}
		DBUtil.freeConnection(conn);
		return result;
	}
	public List<gradeBean> addexcel(String a) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		 String[] tt=a.split("\\s+");
		 int b=0;
		 List<gradeBean> list = new ArrayList<gradeBean>();
		 
		
	        for(String s:tt)
	        {
	        	b++;
	            System.out.println(s);
	            
	        }
	        System.out.println(b);
	        int c=b/4;
	        System.out.println(c);
	        String[][] datas = new String[c][4];
	        String[] data2=new String[c];
	        for(int i=0;i<c;i++){
	        	 gradeBean bean = new gradeBean();
	        	 datas[i][0]=tt[i*4+0];
	        	datas[i][1]=tt[i*4+1];
	        	 datas[i][2]=tt[i*4+2];
	        	 data2[i]=tt[i*4+3];
	        	 System.out.println(datas[i][0]);
	        	System.out.println("zify"+data2[i]);
	        	   bean.setStudentId(Integer.parseInt(datas[i][0]));
	        //	 bean.setStudentId((int) datas[i][0]);
	 	        System.out.println(bean.getStudentId()+"bean ����");
	 	       bean.setCourseId(Integer.parseInt(datas[i][1]));
	 	       // bean.setCourseId((int) datas[i][1]);
	 	       // bean.setGrade((int) datas[i][2]);
	 	       bean.setGrade(Integer.parseInt(datas[i][2]));
	 	       bean.setCreatetime(data2[i]);
		        list.add(bean);
		        System.out.println("bean ����");
	        }
	        /*for(int i =0;i<c;i++){
	        	   System.out.println("bean ����");
	        	 gradeBean bean = new gradeBean();
	        bean.setStudentId((int) datas[i][0]);
	        System.out.println(bean.getStudentId()+"bean ����");
	        bean.setCourseId((int) datas[i][1]);
	        bean.setGrade((int) datas[i][2]);
	        bean.setCreatetime(data2[i]);
	        list.add(bean);
	        }*/
	        System.out.println("return");
		return list;
	}


}

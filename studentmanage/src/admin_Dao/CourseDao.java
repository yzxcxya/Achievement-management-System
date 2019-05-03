package admin_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Acdemy;
import bean.CourseList;
import util.ConnectionUtil;
import util.Pager;

public class CourseDao {
	public ArrayList<CourseList> List() throws ClassNotFoundException, SQLException{
		ArrayList<CourseList> list = new ArrayList<CourseList>();
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
		String sql="select * from course";
	
		
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		ResultSet rs = stmt.executeQuery(sql);		
		
		while(rs.next()) {
			CourseList course = new CourseList();
			course.setCourseId(rs.getInt("courseId"));
			course.setCourseName(rs.getString("courseName"));
			course.setCourseProperty(rs.getString("courseproperty"));
			course.setCourseWay(rs.getString("courseway"));
			course.setCourseCredit(rs.getInt("coursecredit"));
			list.add(course);
		}
		rs.close();
		stmt.close();
		conn.close();
		}
		return list;
		
	}
	
	public CourseList CourseListInfo(String courseId) throws ClassNotFoundException, SQLException {
		CourseList course = new CourseList();
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
			String sql = "select * from course where courseId = "+courseId;
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				course.setCourseId(rs.getInt("courseId"));
				course.setCourseName(rs.getString("courseName"));
				course.setCourseProperty(rs.getString("courseproperty"));
				course.setCourseWay(rs.getString("courseway"));
				course.setCourseCredit(rs.getInt("coursecredit"));
			}
			rs.close();
			stmt.close();
			conn.close();
		}
		
		return course;
	}
	
	public ArrayList<CourseList> List(Pager pager,String courseId,String courseName,String courseCredit) throws ClassNotFoundException, SQLException{
		ArrayList<CourseList> list = new ArrayList<CourseList>();
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
		String sql="select count(*) from course";
		String whereSql = " where 1=1 ";
		
		if (courseId != null && !"".equals(courseId))
			whereSql += " and courseId =" + courseId + "";
		if (courseName != null && !"".equals(courseName))
			whereSql += " and courseName like '%" + courseName + "%'";
		if (courseCredit != null && !"".equals(courseCredit))
			whereSql += " and courseCredit like '%" + courseCredit + "%'";
		
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		ResultSet rs = stmt.executeQuery(sql+whereSql);
		
		int totalCount = 0;
		if (rs.next())  {
			totalCount = rs.getInt(1);
		}
		rs.close();
		pager.setTotalRecord(totalCount);
		
		
		sql = "select * from course "+whereSql+" limit "+ (pager.getCurPage()-1) * pager.getPageSize()+","+pager.getPageSize();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			CourseList course = new CourseList();
			course.setCourseId(rs.getInt("courseId"));
			course.setCourseName(rs.getString("courseName"));
			course.setCourseProperty(rs.getString("courseproperty"));
			course.setCourseWay(rs.getString("courseway"));
			course.setCourseCredit(rs.getInt("coursecredit"));
			list.add(course);
		}
		rs.close();
		stmt.close();
		conn.close();
		}
		return list;
		
	}
	
	public int add(int courseId,String courseName,String courseproperty,String courseway,int coursecredit ) throws ClassNotFoundException, SQLException {
		int result = 0;
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
			String sql = "insert into course(courseId,courseName,courseproperty,courseway,coursecredit) values(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, courseId);
			pstmt.setString(2, courseName);
			pstmt.setString(3, courseproperty);
			pstmt.setString(4, courseway);
			pstmt.setInt(5, coursecredit);
			result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}
		return result;
	}
	
	public int updata(CourseList bean,String courseId) throws ClassNotFoundException, SQLException{
		int result = 0;
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
			String sql="update course set coursename = ? ,courseproperty = ?,courseway = ?,coursecredit = ? where courseId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString (1, bean.getCourseName());
			pstmt.setString(2, bean.getCourseProperty());
			pstmt.setString(3, bean.getCourseWay());
			pstmt.setInt(4, bean.getCourseCredit());
			pstmt.setInt(5, Integer.parseInt(courseId));
			result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}
		return result;
	}
	
	public int delete(String courseId) throws ClassNotFoundException, SQLException {
		int result=0;
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
			String sql ="delete from course where courseId= ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(courseId));
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}
		
		return result;
	}
}

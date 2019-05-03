package StudentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Utils.DBUtil;
import bean.Grade;
import bean.Student;

public class StudentDao {

	public static Student StudentInfo(String studentId) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getConnection();
		if(conn!=null) {
			Student student = new Student();
			String sql = "select * from student where studentId=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, studentId);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				student.setId(rs.getString("studentId"));
				student.setName(rs.getString("studentName"));
				student.setPassword(rs.getString("password"));
				student.setSex(rs.getString("sex"));
				student.setNation(rs.getString("nation"));
				student.setClassId(rs.getString("classId"));
				student.setAcdemyId(rs.getString("acdemyId"));
				student.setTel(rs.getString("tel"));
				student.setAdmissiontime(rs.getString("admissionTime"));
				student.setAddress(rs.getString("address"));
				student.setImage(rs.getString("image"));
			}
			return student;
		}
		return null;
	}
	
	public static List<Grade> GradeInfo(String time,String StudentId) throws ClassNotFoundException, SQLException{
		Connection conn = DBUtil.getConnection();
		List<Grade> list = new ArrayList<Grade>();
		if(conn!=null) {
			String sql ="select courseName,grade,courseCredit,courseProperty,courseWay from student,grade,course where student.studentId=grade.studentId and course.courseId=grade.courseId and student.studentId=? and createTime=?"; 
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, StudentId);
			psmt.setString(2, time);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				Grade grade = new Grade();
				grade.setCourseName(rs.getString("courseName"));
				grade.setGrade(rs.getInt("grade"));
				grade.setCourseProperty(rs.getString("courseProperty"));
				grade.setCourseWay(rs.getString("courseWay"));
				grade.setCourseCredit(rs.getInt("courseCredit"));
				list.add(grade);
			}
			return list;
		}
		return null;
	}

	public static int editInfo(String StuId, String newPassword) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getConnection();
		int result=0;
		if(conn!=null) {
			String sql = "Update student set password=? where studentId=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, newPassword);
			psmt.setString(2, StuId);
			result = psmt.executeUpdate();
		}else {
			result = -1;
		}
		return result;
	}

	public int addImage(Student stu) throws ClassNotFoundException, SQLException {
		int result=0;
		Connection conn = DBUtil.getConnection();
		if (conn != null) {
			String sql="update student set image = ? where studentId=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, stu.getId());
			pstmt.setString(1, stu.getImage());
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		}
		
		return result;
	}
	public static List<Grade> UnGradeInfo(String stuId) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getConnection();
		List<Grade> list = new ArrayList<Grade>();
		if(conn!=null) {
			String sql ="select courseName,grade,courseCredit,courseProperty,courseWay,createTime from student,grade,course where student.studentId=grade.studentId and course.courseId=grade.courseId and student.studentId=? and grade<60"; 
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, stuId);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				Grade grade = new Grade();
				grade.setCourseName(rs.getString("courseName"));
				grade.setGrade(rs.getInt("grade"));
				grade.setCourseProperty(rs.getString("courseProperty"));
				grade.setCourseWay(rs.getString("courseWay"));
				grade.setCourseCredit(rs.getInt("courseCredit"));
				grade.setCreatTime(rs.getString("createTime"));
				list.add(grade);
			}
			return list;
		}
		return null;
	}

	public static int UnGradeTotalCredit(String stuId) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getConnection();
		int totalCredit = 0;
		if(conn!=null) {
			String sql ="select SUM(courseCredit) from student,grade,course where student.studentId=grade.studentId and course.courseId=grade.courseId and student.studentId=? and grade<60"; 
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, stuId);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				totalCredit=rs.getInt("SUM(courseCredit)");
				return totalCredit;
			}
		}
		return -1;
	}
	public static double avgGrade(String createTime, String stuId) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getConnection();
		double avgGrade = 0;
		if(conn!=null) {
			String sql ="select avg(grade) from student,grade,course where student.studentId=grade.studentId and course.courseId=grade.courseId and student.studentId=? and createTime=?"; 
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, stuId);
			psmt.setString(2, createTime);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				avgGrade=rs.getInt("avg(grade)");
				return avgGrade;
			}
		}
		return -1;
	}

	public static double sumGrade(String createTime, String stuId) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getConnection();
		double sumGrade = 0;
		if(conn!=null) {
			String sql ="select sum(grade) from student,grade,course where student.studentId=grade.studentId and course.courseId=grade.courseId and student.studentId=? and createTime=?"; 
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, stuId);
			psmt.setString(2, createTime);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				sumGrade=rs.getInt("sum(grade)");
				return sumGrade;
			}
		}
		return -1;
	}

}

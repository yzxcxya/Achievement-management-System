package admin_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import bean.Student;
import bean.StudentList;
import util.ConnectionUtil;
import util.Pager;

public class StudentDao {
	public ArrayList<StudentList> List() throws ClassNotFoundException, SQLException{
		ArrayList<StudentList> list = new ArrayList<StudentList>();
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
		String sql="select * from student";
	
		
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		ResultSet rs = stmt.executeQuery(sql);		
		
		while(rs.next()) {
			StudentList student = new StudentList();
			student.setStudentId(rs.getInt("StudentId"));
			student.setClassId(rs.getInt("classId"));
			student.setAddress(rs.getString("address"));
			student.setAcdemyId(rs.getInt("acdemyid"));
			student.setSex(rs.getString("sex"));
			student.setNation(rs.getString("nation"));
			student.setImage(rs.getString("image"));
			student.setTel(rs.getString("tel"));
			student.setTotalCredits(rs.getInt("totalcredits"));
			student.setTevisedCredits(rs.getInt("tevisedcredits"));
			student.setUnpaidCredits(rs.getInt("unpaidcredits"));
			student.setStudentName(rs.getString("studentName"));
			student.setAdmissiontime(rs.getDate("admissiontime"));
			student.setPassword(rs.getString("password"));
			list.add(student);
		}
		rs.close();
		stmt.close();
		conn.close();
		}
		return list;
		
	}
	
	public StudentList StudentListInfo(String studentId) throws ClassNotFoundException, SQLException {
		StudentList student = new StudentList();
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
			String sql = "select * from student where studentId = "+studentId;
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				
				student.setStudentId(rs.getInt("StudentId"));
				student.setClassId(rs.getInt("classId"));
				student.setAddress(rs.getString("address"));
				student.setAcdemyId(rs.getInt("acdemyid"));
				student.setSex(rs.getString("sex"));
				student.setNation(rs.getString("nation"));
				student.setImage(rs.getString("image"));
				student.setTel(rs.getString("tel"));
				student.setTotalCredits(rs.getInt("totalcredits"));
				student.setTevisedCredits(rs.getInt("tevisedcredits"));
				student.setUnpaidCredits(rs.getInt("unpaidcredits"));
				student.setStudentName(rs.getString("studentName"));
				student.setAdmissiontime(rs.getDate("admissiontime"));
				student.setPassword(rs.getString("password"));
			}
			rs.close();
			stmt.close();
			conn.close();
		}
		
		return student;
	}
	
	public ArrayList<StudentList> List(Pager pager,String studentId,String classId,String acdemyId) throws ClassNotFoundException, SQLException{
		ArrayList<StudentList> list = new ArrayList<StudentList>();
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
		String sql="select count(*) from student";
		String whereSql = " where 1=1 ";
		if (studentId != null && !"".equals(studentId))
			whereSql += " and studentId =" + studentId + "";
		if (classId != null && !"".equals(classId))
			whereSql += " and classId like '%" + classId + "%'";
		if (acdemyId != null && !"".equals(acdemyId))
			whereSql += " and acdemyId like '%" + acdemyId + "%'";
		System.out.println("sql:" + sql+whereSql);
		
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		ResultSet rs = stmt.executeQuery(sql+whereSql);
		
		int totalCount = 0;
		if (rs.next())  {
			totalCount = rs.getInt(1);
		}
		rs.close();
		pager.setTotalRecord(totalCount);
		System.out.println(studentId);
		
		
		sql = "select * from student "+whereSql+" limit "+ (pager.getCurPage()-1) * pager.getPageSize()+","+pager.getPageSize();
		
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			StudentList student = new StudentList();
			student.setStudentId(rs.getInt("StudentId"));
			student.setClassId(rs.getInt("classId"));
			student.setAddress(rs.getString("address"));
			student.setAcdemyId(rs.getInt("acdemyid"));
			student.setSex(rs.getString("sex"));
			student.setNation(rs.getString("nation"));
			student.setImage(rs.getString("image"));
			student.setTel(rs.getString("tel"));
			student.setTotalCredits(rs.getInt("totalcredits"));
			student.setTevisedCredits(rs.getInt("tevisedcredits"));
			student.setUnpaidCredits(rs.getInt("unpaidcredits"));
			student.setStudentName(rs.getString("studentName"));
			student.setAdmissiontime(rs.getDate("admissiontime"));
			student.setPassword(rs.getString("password"));
			list.add(student);
		}
		rs.close();
		stmt.close();
		conn.close();
		}
		return list;
		
	}
	
	public int add(int studentId,String studentName,String password,String sex,String nation,int classId,int acdemyId,String tel,String admissiontime,String address,String image ) throws ClassNotFoundException, SQLException {
		int result = 0;
		Connection conn = ConnectionUtil.getConnection();
		int a=0;
		int b=0;
		int c=0;
		if (conn != null) {
			String sql = "insert into student(studentId,studentName,password,sex,nation,classId,acdemyId,tel,admissiontime,address,image,totalCredits,tevisedCredits,unpaidCredits) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studentId);
			pstmt.setString(2, studentName);
			pstmt.setString(3, password);
			pstmt.setString(4, sex);
			pstmt.setString(5, nation);
			pstmt.setInt(6, classId);
			pstmt.setInt(7, acdemyId);
			pstmt.setString(8, tel);
			
			pstmt.setString(9,admissiontime);
			pstmt.setString(10, address);
			pstmt.setString(11, image);
			pstmt.setDouble(12, a);
			pstmt.setDouble(13, b);
			pstmt.setDouble(14, c);
			result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}
		return result;
	}
	
	public int updata(StudentList bean,String studentId) throws ClassNotFoundException, SQLException{
		int result = 0;
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
			String sql="update student set studentName = ?, sex = ?,nation = ?,classId = ?,acdemyId = ?,tel = ?,address = ? where studentId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bean.getStudentName());
			
			pstmt.setString(2, bean.getSex());
			pstmt.setString(3, bean.getNation());
			pstmt.setInt(4, bean.getClassId());
			pstmt.setInt(5, bean.getAcdemyId());
			pstmt.setString(6, bean.getTel());
			
			
			pstmt.setString(7, bean.getAddress());
			
			pstmt.setInt(8, Integer.parseInt(studentId));
			result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}
		return result;
	}
	
	public int delete(String studentId) throws ClassNotFoundException, SQLException {
		int result=0;
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
			String sql ="update student set studentName = 0, sex = 0,nation = 0,tel = 0,address = 0,image = 0,totalCredits = 0,tevisedCredits = 0,unpaidCredits = 0,password = 0 where studentId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(studentId));
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}
		
		return result;
	}
	
	public int editImage(Student Bean) throws ClassNotFoundException, SQLException {
		int result=0;
		Connection conn = ConnectionUtil.getConnection();
		if (conn != null) {
			String sql="update student set image = ? where studentId=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(2, Integer.parseInt(Bean.getId()));
			pstmt.setString(1, Bean.getImage());
			
result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}
		
		return result;
	}

}

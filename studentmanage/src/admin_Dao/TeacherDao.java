package admin_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.TeacherList;
import util.ConnectionUtil;
import util.Pager;

public class TeacherDao {
	
	public ArrayList<TeacherList> List(String teacherId,String teacherName,String acdemyId,Pager pager) throws ClassNotFoundException, SQLException{
		ArrayList<TeacherList> list = new ArrayList<TeacherList>();
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
		String sql="select count(*) from Teacher";
		
		String whereSql = " where 1=1 ";
		if(teacherId!=null&&!"".equals(teacherId)) {
			whereSql += " and teacherId like '%"+teacherId+"%'";
		}
		if(teacherName!=null&&!"".equals(teacherName)) {
			whereSql += " and teacherName like '%"+teacherName+"%'";
		}
		if(acdemyId!=null&&!"".equals(acdemyId)) {
			whereSql += " and teacher.acdemyId ="+acdemyId;
		}
		
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		System.out.println(sql+whereSql);
		ResultSet rs = stmt.executeQuery(sql+whereSql);
		
		int totalCount = 0;
		if (rs.next())  {
			totalCount = rs.getInt(1);
		}
		rs.close();
		pager.setTotalRecord(totalCount);
		
		sql = "select * from teacher,acdemy "+whereSql+" and teacher.acdemyId=acdemy.acdemyId "+" limit "+ (pager.getCurPage()-1) * pager.getPageSize()+","+ pager.getPageSize();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			TeacherList TeacherList = new TeacherList();
			TeacherList.setTeacherId(rs.getInt("teacherId"));
			TeacherList.setTeacherName(rs.getString("teacherName"));
			TeacherList.setTel(rs.getString("tel"));
			TeacherList.setSex(rs.getString("sex"));
			TeacherList.setNation(rs.getString("nation"));
			TeacherList.setImage(rs.getString("image"));
			TeacherList.setAcdemyName(rs.getString("acdemyName"));
			TeacherList.setAddress(rs.getString("address"));
			list.add(TeacherList);
		}
		rs.close();
		stmt.close();
		conn.close();
		}
		return list;
		
	}
	
	public TeacherList teacher(int teacherId) throws ClassNotFoundException, SQLException {
		TeacherList bean=null;
		
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
			String sql = "select * from teacher,acdemy where teacher.acdemyId=acdemy.acdemyId and teacherId = "+teacherId;
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				TeacherList TeacherList = new TeacherList();
				TeacherList.setTeacherId(rs.getInt("teacherId"));
				TeacherList.setTeacherName(rs.getString("teacherName"));
				TeacherList.setTel(rs.getString("tel"));
				TeacherList.setSex(rs.getString("sex"));
				TeacherList.setAcdemyName(rs.getString("acdemyName"));
				TeacherList.setAddress(rs.getString("address"));
				bean = TeacherList;
			}
			rs.close();
			stmt.close();
			conn.close();
		}
		
		return bean;
	}
	
	public int update(TeacherList bean) throws ClassNotFoundException, SQLException {
		int result=0;
		
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
			String sql="update teacher set teacherId = ?,teacherName=?, tel=?, address=?, acdemyId=? where teacherId=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getTeacherId());
			pstmt.setString(2, bean.getTeacherName());
			pstmt.setString(3, bean.getTel());
			pstmt.setString(4, bean.getAddress());
			pstmt.setInt(5, bean.getAcdemyId());
			pstmt.setInt(6, bean.getTeacherId());
			
			System.out.println("teachername:"+bean.getTeacherName());
			System.out.println("sql"+sql);
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		}
		
		return result;
	}
	
	public int delete(String id) throws ClassNotFoundException, SQLException {
		int result=0;
		Connection conn = ConnectionUtil.getConnection();
		if (conn != null) {
			String sql ="delete from teacher where teacherId= ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(id));
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}
		
		return result;
	}
	
	public int insert(TeacherList bean) throws ClassNotFoundException, SQLException {
		int result=0;
		Connection conn = ConnectionUtil.getConnection();
		if (conn != null) {
			String sql ="insert into teacher(teacherId,teacherName,tel,password,address,sex,acdemyId) values(?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bean.getTeacherId());
			pstmt.setString(2, bean.getTeacherName());
			pstmt.setString(3, bean.getTel());
			pstmt.setString(4, bean.getPasword());
			pstmt.setString(5, bean.getAddress());
			pstmt.setString(6, bean.getSex());
			pstmt.setInt(7, bean.getAcdemyId());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}	
		return result;
	}
	
	public int addImage(TeacherList bean) throws ClassNotFoundException, SQLException {
		int result=0;
		Connection conn = ConnectionUtil.getConnection();
		if (conn != null) {
			String sql="update teacher set image = ? where teacherId=?";
PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(2, bean.getTeacherId());
			pstmt.setString(1, bean.getImage());
			
result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}
		
		return result;
	}
}

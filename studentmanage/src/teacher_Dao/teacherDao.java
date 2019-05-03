package teacher_Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Teacher;
import util.DBUtil;



public class teacherDao {
	public teacherBean loadFile(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException  {
		teacherBean bean = new teacherBean();
		Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		String url = "jdbc:mysql://localhost:3306/Grade?useSSL=false";
		Connection conn = DriverManager.getConnection(url, "user", "user");

	
		return bean;
	}
	
	public static Teacher TeacherInfo(String id) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getConnection();
		if(conn!=null) {
			Teacher teacher = new Teacher();
			String sql = "select * from teacher where teacherId=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				teacher.setId(rs.getString("teacherId"));
				teacher.setName(rs.getString("teacherName"));
				teacher.setPassword(rs.getString("password"));
				teacher.setSex(rs.getString("sex"));
				teacher.setNation(rs.getString("nation"));
				teacher.setTel(rs.getString("tel"));
				teacher.setAddress(rs.getString("address"));
				teacher.setImage(rs.getString("image"));
			}
			return teacher;
		}
		return null;
	}

	public static boolean TeacherInfoEdit(Teacher tec, String teacherId) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getConnection();
		if(conn!=null) {
			String sql = "Update teacher set tel=?,password=?,sex=?,address=?,nation=? where teacherId=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, tec.getTel());
			psmt.setString(2, tec.getPassword());
			psmt.setString(3, tec.getSex());
			psmt.setString(4, tec.getAddress());
			psmt.setString(5, tec.getNation());
			psmt.setString(6, teacherId);
			int result = psmt.executeUpdate();
			if(result>0) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

	public int addImage(Teacher teacher) throws ClassNotFoundException, SQLException {
		int result=0;
		Connection conn = DBUtil.getConnection();
		if (conn != null) {
			String sql="update teacher set image = ? where teacherId=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, teacher.getId());
			pstmt.setString(1, teacher.getImage());
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		}
		
		return result;
	}

}

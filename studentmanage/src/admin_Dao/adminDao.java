package admin_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.DBUtil;
import bean.Admin;
import bean.Teacher;

public class adminDao {
	
	public int editAdmin() {
		return 0;
		
	}
	public static Admin AdminInfo(String id) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getConnection();
		if(conn!=null) {
			Admin adm = new Admin();
			String sql = "select * from manage where adminId=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				adm.setId(rs.getString("adminId"));
				adm.setName(rs.getString("adminName"));
				adm.setPassword(rs.getString("password"));
				adm.setSex(rs.getString("sex"));
				adm.setTel(rs.getString("tel"));
				adm.setAddress(rs.getString("address"));
				adm.setImage(rs.getString("image"));
			}
			return adm;
		}
		return null;
	}
	public static boolean AdminInfoEdit(Admin admin, String adminId) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getConnection();
		if(conn!=null) {
			String sql = "Update manage set adminId=?,adminName=?,tel=?,password=?,sex=?,address=? where adminId=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, admin.getId());
			psmt.setString(2, admin.getName());
			psmt.setString(3, admin.getTel());
			psmt.setString(4, admin.getPassword());
			psmt.setString(5, admin.getSex());
			psmt.setString(6, admin.getAddress());
			psmt.setString(7, adminId);
			int result = psmt.executeUpdate();
			if(result>0) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	public int addImage(Admin admin) throws ClassNotFoundException, SQLException {
		int result=0;
		Connection conn = DBUtil.getConnection();
		if (conn != null) {
			String sql="update manage set image = ? where adminId=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, admin.getId());
			pstmt.setString(1, admin.getImage());
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		}
		
		return result;
	}
}

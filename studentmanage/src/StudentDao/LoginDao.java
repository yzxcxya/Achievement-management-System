package StudentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.DBUtil;
import bean.Admin;
import bean.Student;
import bean.Teacher;

public class LoginDao {

	public static int checkStu(Student stu) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getConnection();
		if(conn!=null) {
			String sql1 = "select * from Student where studentId = ?";
			PreparedStatement psmt1 = conn.prepareStatement(sql1);
			psmt1.setString(1, stu.getId());
			ResultSet rs1 = psmt1.executeQuery();
			if(rs1.next()) {
				String sql2 = "select * from Student where studentId = ? and password = ?";
				PreparedStatement psmt2 = conn.prepareStatement(sql2);
				psmt2.setString(1, stu.getId());
				psmt2.setString(2, stu.getPassword());
				ResultSet rs2 = psmt2.executeQuery();
				if(rs2.next()) {
					return 0;
				}else
					return 1;
			}
			return 2;
			
		}
		return 3;
	}
	
	public static int checkTec(Teacher tec) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getConnection();
		if(conn!=null) {
			String sql1 = "select * from Teacher where TeacherId = ?";
			PreparedStatement psmt1 = conn.prepareStatement(sql1);
			psmt1.setString(1, tec.getId());
			ResultSet rs1 = psmt1.executeQuery();
			if(rs1.next()) {
				String sql2 = "select * from Teacher where TeacherId = ? and password = ?";
				PreparedStatement psmt2 = conn.prepareStatement(sql2);
				psmt2.setString(1, tec.getId());
				psmt2.setString(2, tec.getPassword());
				ResultSet rs2 = psmt2.executeQuery();
				if(rs2.next()) {
					return 0;
				}else
					return 1;
			}
			return 2;
		}
		return 3;
	}
	
	public static int checkAdm(Admin adm) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getConnection();
		if(conn!=null) {
			String sql1 = "select * from manage where AdminId = ?";
			PreparedStatement psmt1 = conn.prepareStatement(sql1);
			psmt1.setString(1, adm.getId());
			ResultSet rs1 = psmt1.executeQuery();
			if(rs1.next()) {
				String sql2 = "select * from manage where AdminId = ? and password = ?";
				PreparedStatement psmt2 = conn.prepareStatement(sql2);
				psmt2.setString(1, adm.getId());
				psmt2.setString(2, adm.getPassword());
				ResultSet rs2 = psmt2.executeQuery();
				if(rs2.next()) {
					return 0;
				}else
					return 1;
			}
			return 2;
		}
		return 3;
	}
}

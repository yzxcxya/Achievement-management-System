package admin_Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Acdemy;
import bean.Classes;
import util.ConnectionUtil;

public class ClassDao {
	
	public ArrayList<Classes> Classlist() throws ClassNotFoundException, SQLException{
		ArrayList<Classes> list = new ArrayList<Classes>();
		
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
		String sql="select * from class";
	
		
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		ResultSet rs = stmt.executeQuery(sql);		
		
		while(rs.next()) {
			Classes bean = new Classes();
			bean.setClazz(rs.getInt("classId"));
			list.add(bean);
		}
		rs.close();
		stmt.close();
		conn.close();	
	}
		return list;
	}
}

package admin_Dao;

import java.sql.*;
import java.util.ArrayList;

import bean.Acdemy;
import util.ConnectionUtil;
import util.Pager;

public class AcdemyDao {
	
	public ArrayList<Acdemy> List() throws ClassNotFoundException, SQLException{
		ArrayList<Acdemy> list = new ArrayList<Acdemy>();
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
		String sql="select * from acdemy";
	
		
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		ResultSet rs = stmt.executeQuery(sql);		
		
		while(rs.next()) {
			Acdemy acdemy = new Acdemy();
			acdemy.setAcdemyId(rs.getInt("acdemyId"));
			acdemy.setAcdemyName(rs.getString("acdemyName"));
			list.add(acdemy);
		}
		rs.close();
		stmt.close();
		conn.close();
		}
		return list;
		
	}
	
	public Acdemy AcdemyInfo(String acdemyId) throws ClassNotFoundException, SQLException {
		Acdemy acdemy = new Acdemy();
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
			String sql = "select * from acdemy where acdemyId = "+acdemyId;
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				acdemy.setAcdemyId(rs.getInt("acdemyId"));
				acdemy.setAcdemyName(rs.getString("acdemyName"));
			}
			rs.close();
			stmt.close();
			conn.close();
		}
		
		return acdemy;
	}
	
	public ArrayList<Acdemy> List(Pager pager) throws ClassNotFoundException, SQLException{
		ArrayList<Acdemy> list = new ArrayList<Acdemy>();
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
		String sql="select count(*) from acdemy";
		String whereSql = " where 1=1 ";
		
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		ResultSet rs = stmt.executeQuery(sql+whereSql);
		
		int totalCount = 0;
		if (rs.next())  {
			totalCount = rs.getInt(1);
		}
		rs.close();
		pager.setTotalRecord(totalCount);
		
		sql = "select * from acdemy "+whereSql+"limit "+ (pager.getCurPage()-1) * pager.getPageSize()+","+pager.getPageSize();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			Acdemy acdemy = new Acdemy();
			acdemy.setAcdemyId(rs.getInt("acdemyId"));
			acdemy.setAcdemyName(rs.getString("acdemyName"));
			list.add(acdemy);
		}
		rs.close();
		stmt.close();
		conn.close();
		}
		return list;
		
	}
	
	public int add(int acdemyId,String acdemyName) throws ClassNotFoundException, SQLException {
		int result = 0;
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
			String sql = "insert into acdemy(acdemyId,acdemyName) values(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, acdemyId);
			pstmt.setString(2, acdemyName);
			result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}
		return result;
	}
	
	public int updata(Acdemy bean,String id) throws ClassNotFoundException, SQLException{
		int result = 0;
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
			String sql="update acdemy set acdemyId = ? ,acdemyName = ? where acdemyId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bean.getAcdemyId());
			pstmt.setString(2, bean.getAcdemyName());
			pstmt.setInt(3, Integer.parseInt(id));
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
			String sql ="delete from acdemy where acdemyId= ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(id));
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}
		
		return result;
	}
}

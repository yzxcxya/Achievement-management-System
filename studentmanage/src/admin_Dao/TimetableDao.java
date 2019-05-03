package admin_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Timetable;
import bean.TimetableList;
import util.ConnectionUtil;

public class TimetableDao {
	
	public List<ArrayList<Timetable>> TimeTableList(Timetable tables) throws ClassNotFoundException, SQLException{
		List<ArrayList<Timetable>> list = new ArrayList<ArrayList<Timetable>>();
		
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
			String sql="select * from Timetable,course,teacher where course.courseId = Timetable.courseId and timetable.teacherId=teacher.teacherId";
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String whereSql = "";
			if(tables.getTeacherId()!=0) {
				whereSql += " and Timetable.teacherId = "+tables.getTeacherId();
			}
			if(tables.getCourseId()!=0) {
				whereSql += " and classId ="+tables.getCourseId();
			}
			if(tables.getWeeks()!=null&&!"".equals(tables.getWeeks())) {
				whereSql += " and weeks ="+tables.getWeeks();
			}
			
			System.out.println(sql+whereSql);
			ResultSet rs = stmt.executeQuery(sql+whereSql);		
			
			while(rs.next()) {
				if(list.size()==0) {//课表为空时插入数据
					ArrayList<Timetable> list1 = new ArrayList<Timetable>();
					Timetable table = new Timetable();
					table.setTeacherId(rs.getInt("teacherId"));
					table.setTeacherName(rs.getString("teacherName"));
					table.setCourseId(rs.getInt("course.courseId"));
					table.setCourseName(rs.getString("courseName"));
					table.setAddress(rs.getString("address"));
					table.setWeeks(rs.getInt("weeks")+"");

					table.setWeekdays(rs.getInt("weekdays"));
					table.setTimes(rs.getInt("times"));
					list1.add(table);
					list.add(list1);
					System.out.println(list1.get(0).toString());
				}else {
					int chance=0;
					for(int i=0;i<list.size();i++) {//遍历已有每个小课表的数据
						
						for(int j=0;j<list.get(i).size();j++) {//遍历课表数据
							if(rs.getInt("weekdays")==list.get(i).get(j).getWeekdays()
							&&rs.getInt("times")==list.get(i).get(j).getTimes()) {//如果星期和节次相同
								if(rs.getInt("courseId")==(list.get(i).get(j).getCourseId())&&rs.getString("address").equals(list.get(i).get(j).getAddress())) {//如果课程不同插入新的数据
								 	if(rs.getInt("teacherId")!=(list.get(i).get(j).getTeacherId())) {
										list.get(i).get(j).addTeacherName(rs.getString("teacherName"));
									}
									if(!list.get(i).get(j).getWeeks().contains(rs.getInt("weeks")+"")) {
										list.get(i).get(j).Addweeks(rs.getInt("weeks")+"");

									}
									//list.get(i).get(j).AddcourseName(rs.getString("courseName"));
									//list.get(i).get(j).Addaddress(rs.getString("address"));				
								}else {
									Timetable table = new Timetable();
									table.setTeacherId(rs.getInt("teacherId"));
									table.setTeacherName(rs.getString("teacherName"));
									table.setCourseId(rs.getInt("course.courseId"));
									table.setCourseName(rs.getString("courseName"));
									table.setAddress(rs.getString("address"));
									table.setWeeks(rs.getInt("weeks")+"");

									table.setWeekdays(rs.getInt("weekdays"));
									table.setTimes(rs.getInt("times"));
									list.get(i).add(table);
									
								}
								chance++;
							}
							
						}
					}
					
					if(chance==0) {
						ArrayList<Timetable> list1 = new ArrayList<Timetable>();
						Timetable table = new Timetable();
						table.setTeacherId(rs.getInt("teacherId"));
						table.setTeacherName(rs.getString("teacherName"));
						table.setCourseId(rs.getInt("course.courseId"));
						table.setCourseName(rs.getString("courseName"));
						table.setAddress(rs.getString("address"));
						table.setWeeks(rs.getInt("weeks")+"");
						table.setWeekdays(rs.getInt("weekdays"));
						table.setTimes(rs.getInt("times"));
						list1.add(table);
						list.add(list1);
					}
				}
			}
			
		}
		
		return list;
	}
	
	public int add(Timetable table) throws ClassNotFoundException, SQLException {
		int result=0;
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
			if(checkclash(table)>0) {
				String sql4="insert into timetable(teacherId,classId,courseId,address,weeks,weekdays,times) values(?,?,?,?,?,?,?)";
				PreparedStatement pstmt = conn.prepareStatement(sql4);
		
				pstmt.setInt(1, table.getTeacherId());
				pstmt.setInt(2, table.getClassId());
				pstmt.setInt(3, table.getCourseId());
				pstmt.setString(4, table.getAddress());
				pstmt.setInt(5, table.getWeekes());
				pstmt.setInt(6, table.getWeekdays());
				pstmt.setInt(7, table.getTimes());
		
				result= pstmt.executeUpdate();
			}else {
				return checkclash(table);
			}
		}
		return result;
	}
	
	public int delete(Timetable table) throws ClassNotFoundException, SQLException {
		int result=0;
		Connection conn = ConnectionUtil.getConnection();
		
		if (conn != null) {
			String sql1="select * from timetable where times=? and weekdays=? and weeks=? and teacherId=?";
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			
			pstmt1.setInt(1, table.getTimes());
			pstmt1.setInt(2, table.getWeekdays());
			pstmt1.setInt(3, table.getWeekes());
			pstmt1.setInt(4, table.getTeacherId());
			
			ResultSet rs = pstmt1.executeQuery();
			
			if(rs.next()) {
				rs.close();
				String sql2="delete from timetable where times=? and weekdays=? and weeks=? and teacherId=?";
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				
				pstmt2.setInt(1, table.getTimes());
				pstmt2.setInt(2, table.getWeekdays());
				pstmt2.setInt(3, table.getWeekes());
				pstmt2.setInt(4, table.getTeacherId());
				
			    result = pstmt2.executeUpdate();
			    pstmt2.close();
			    return result;
			}
				rs.close();
				pstmt1.close();
				conn.close();
				return -2;
			
		}
		return result;
	}
	
	public Timetable check(Timetable table) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionUtil.getConnection();
		Timetable table1 = new Timetable();
		if (conn != null) {
			String sql1="select * from timetable,course where course.courseId=timetable.courseId and times=? and weekdays=? and weeks=? and teacherId=?";
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			
			pstmt1.setInt(1, table.getTimes());
			pstmt1.setInt(2, table.getWeekdays());
			pstmt1.setInt(3, table.getWeekes());
			pstmt1.setInt(4, table.getTeacherId());
			
			ResultSet rs = pstmt1.executeQuery();
			if(rs.next()) {
				table1.setTeacherId(table.getTeacherId());
				table1.setTimes(table.getTimes());
				table1.setWeekes(table.getWeekes());
				table1.setWeekdays(table.getWeekdays());
				table1.setCourseId(rs.getInt("course.courseId"));
				table1.setCourseName(rs.getString("course.courseName"));
				table1.setAddress(rs.getString("address"));
				table1.setClassId(rs.getInt("classId"));
			}
			
		}
		
		return table1;
	}
	public TimetableList find(Timetable table) throws ClassNotFoundException, SQLException {
		TimetableList list = new TimetableList();
		Connection conn = ConnectionUtil.getConnection();
		if (conn != null) {
			String sql1="select * from timetable where times=? and weekdays=? and weeks=? and teacherId=?";
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, table.getTimes());
			pstmt1.setInt(2, table.getWeekdays());
			pstmt1.setInt(3, table.getWeekes());
			pstmt1.setInt(4, table.getTeacherId());
			
			ResultSet rs = pstmt1.executeQuery();
			
			if(rs.next()) {
				list.setTeacherId(table.getTeacherId());
				list.setTimes(table.getTimes());
				list.setWeekes(table.getWeekes());
			}
		}
		
		return list;
	}
	
	public int checkclash(Timetable table) throws ClassNotFoundException, SQLException {
		int result=1;
		Connection conn = ConnectionUtil.getConnection();
		if(conn!=null) {
		String sql1="select * from timetable where times=? and weekdays=? and weeks=? and teacherId=?";
		String sql2="select * from timetable where times=? and weekdays=? and weeks=? and address=?";
		String sql3="select * from timetable where times=? and weekdays=? and weeks=? and classId=?";
		PreparedStatement pstmt1 = conn.prepareStatement(sql1);
		
		pstmt1.setInt(1, table.getTimes());
		pstmt1.setInt(2, table.getWeekdays());
		pstmt1.setInt(3, table.getWeekes());
		pstmt1.setInt(4, table.getTeacherId());
		
		ResultSet rs = pstmt1.executeQuery();
		
		if(rs.next()) {
			rs.close();
			pstmt1.close();
			conn.close();
			return -1;
		}
		pstmt1.close();
		rs.close();
		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		
		pstmt2.setInt(1, table.getTimes());
		pstmt2.setInt(2, table.getWeekdays());
		pstmt2.setInt(3, table.getWeekes());
		pstmt2.setString(4, table.getAddress());
		rs = pstmt2.executeQuery();
		
		if(rs.next()) {
			rs.close();
			pstmt2.close();
			conn.close();
			return -2;
		}
		
		rs.close();
		pstmt2.close();
		PreparedStatement pstmt3 = conn.prepareStatement(sql3);
		
		pstmt3.setInt(1, table.getTimes());
		pstmt3.setInt(2, table.getWeekdays());
		pstmt3.setInt(3, table.getWeekes());
		pstmt3.setInt(4, table.getClassId());
		rs = pstmt3.executeQuery();
		
		if(rs.next()) {
			rs.close();
			pstmt3.close();
			conn.close();
			return -3;
		}
		rs.close();
		pstmt3.close();
		}
		return result;
	}


	
	public int updata(Timetable table1,Timetable table2) throws ClassNotFoundException, SQLException {
		int result = 0;
		Connection conn = ConnectionUtil.getConnection();
		
		if(checkclash(table1)>0) {
		if (conn != null) {
			String sql1="update timetable set times=?,weekdays=?,weeks=?,address=? where times=? and weekdays=? and weeks=? and teacherId=?";
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			
			pstmt1.setInt(1, table1.getTimes());
			pstmt1.setInt(2, table1.getWeekdays());
			pstmt1.setInt(3, table1.getWeekes());
			pstmt1.setString(4, table1.getAddress());
			pstmt1.setInt(5, table2.getTimes());
			pstmt1.setInt(6, table2.getWeekdays());
			pstmt1.setInt(7, table2.getWeekes());
			pstmt1.setInt(8, table2.getTeacherId());
			
			System.out.println("times:"+table1.getTimes()+" weekday "+table1.getWeekdays()+" weeks:"+table1.getWeekes()+" address"+table1.getAddress());
			System.out.println("times:"+table2.getTimes()+" weekday "+table2.getWeekdays()+" weeks:"+table2.getWeekes()+"teacherId"+table2.getTeacherId());
			System.out.println("sql+"+sql1);
			result = pstmt1.executeUpdate();
			pstmt1.close();
			conn.close();
			}
		}else {
			return checkclash(table1);
		}
		
		return result;
	}
}

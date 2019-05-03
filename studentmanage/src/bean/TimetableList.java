package bean;

import java.util.ArrayList;

public class TimetableList {
	int teacherId;
	String teacherName;
	int courseId;
	String courseName;
	String address;
	int classId;
	int weekes;//用于存储一个课表的信息
	String weeks;
	int weekdays;
	int times;
	ArrayList<Integer> weeksList;
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getWeekes() {
		return weekes;
	}
	public void setWeekes(int weekes) {
		this.weekes = weekes;
	}
	public String getWeeks() {
		return weeks;
	}
	public void setWeeks(String weeks) {
		this.weeks = weeks;
	}
	public int getWeekdays() {
		return weekdays;
	}
	public void setWeekdays(int weekdays) {
		this.weekdays = weekdays;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public void addWeeksList(int a) {
		weeksList.add(a);
	}
	
	public ArrayList<Integer> getWeeksList() {
		return weeksList;
	}
	public void setWeeksList(ArrayList<Integer> weeksList) {
		this.weeksList = weeksList;
	}
	
	
	
	
}

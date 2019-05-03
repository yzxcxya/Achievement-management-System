package bean;

import java.util.ArrayList;

public class Timetable {
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
	public String getTeacherName() {
		return teacherName;
	}
	public void addTeacherName(String teacherName) {
		this.teacherName = this.teacherName+","+teacherName;
	}
	
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getCourseId() {
	  return	this.courseId;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void AddcourseName(String courseName) {
		this.courseName = this.courseName+","+courseName;
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
	public void Addweeks(String weeks) {
		this.weeks = this.weeks+","+weeks;;
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
	
	
	
	public ArrayList<Integer> getWeeksList() {
		return weeksList;
	}
	public void setWeeksList(ArrayList<Integer> weeksList) {
		this.weeksList = weeksList;
	}
	@Override
	public String toString() {
		return "Timetable [teacherId=" + teacherId + ", teacherName=" + teacherName + ", courseId=" + courseId
				+ ", courseName=" + courseName + ", address=" + address + ", classId=" + classId + ", weekes=" + weekes
				+ ", weeks=" + weeks + ", weekdays=" + weekdays + ", times=" + times + "]";
	}
	
	
	
}

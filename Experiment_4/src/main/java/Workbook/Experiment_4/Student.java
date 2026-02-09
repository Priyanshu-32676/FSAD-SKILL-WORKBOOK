package Workbook.Experiment_4;

public class Student {
	int id;
	String name;
	String course;
	int year;
	
	
	public Student() {
		super();
	}
	public Student(int id, String name, String course, int year) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.year = year;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Student Details are "+"\nid=" + id + ",\nname=" + name + ",\ncourse=" + course + ",\nyear=" + year;
	}
	
	

}

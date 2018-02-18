package by.htp.Group.model;

public class Student {
	
	private int age;
	private int startYear;

	public Student(int age, int startYear) {
		this.age = age;
		this.startYear = startYear;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getStartYear() {
		return startYear;
	}

	public int getAge() {
		return age;
	}
}

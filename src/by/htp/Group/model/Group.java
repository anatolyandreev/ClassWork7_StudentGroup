package by.htp.Group.model;

import java.util.Scanner;

public class Group {

	private Student[] students;
	private int studentCounter;

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public Student[] getStudents() {
		return this.students;
	}

	// ��� ������� ��������� ���������� �� ��������� � ������ (������ ��� ������ 5��)
	// ����� ������ ��������
	public boolean groupStatus(Student[] students) {
		boolean status = false;
		for (int i = 0; i < 5; i++) {
			if (students[i] == null) {
				status = false;
			} else {
				status = true;
			}
		}
		if (status == false) {
			System.out.println("� ������ ������ 5-�� ���������, �������� ���������");
		} else {
			System.out.println("� ������ 5 ��� ������ ���������");
		}
		return status;
	}

	// ��� ������� ��������� ��������� � ������
	// ���������� ��������� "������" ����� �� 5 ����
	// ������������ warning �� ��, ��� ���������� �������� �������� � ������
	// ���� ���������� ������� ���� � ������ ������ 5
	// ������������ �������� �� ����� ���������� ��������� � ������ �� ��������� 15 �������
	// ����� ������� 16-� ������� � ������ �������� �� �����
	public void addStudent(Student student) {
		if (this.students != null) {
			if (students.length == 15) {
				System.out.println("���������� ����� � ������ �� ����� ���� ������ 15-��");
			} else {
				if (this.groupStatus(students) == true) {
					if (studentCounter < students.length) {
						students[studentCounter] = student;
						studentCounter++;
					} else {
						Student[] students = new Student[this.students.length + 1];
						for (int i = 0; i < this.students.length; i++) {
							students[i] = this.students[i];
						}
						this.students = students;
						this.students[studentCounter] = student;
						studentCounter++;
					}
				} else {
					students[studentCounter] = student;
					studentCounter++;
				}
			}
		} else {
			this.students = new Student[5];
			this.students[studentCounter] = student;
			this.groupStatus(students);
			studentCounter++;
		}
	}
	
	// ��� ������� ���������� ������� ������� ��������� � ������
	public double getMedium() {
		double medium = 0;
		int sum = 0;
		for (int i = 0; i < students.length; i++) {
			sum += students[i].getAge();
			medium = (double) sum / students.length;
		}
		return medium;
	}

	// ��� ������� ���������� ���������� ���������, ����������� � �������� ����
	// �������� ��� �������� � �������
	public int getStudentsNumberByStartDate() {
		int counter = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("������� ���");
		int year = sc.nextInt();
		for (Student student : students) {
			if (student.getStartYear() == year) {
				counter++;
			}
		}
		System.out.println("���������� ���������, ����������� � " + year + " ���� = " + counter);
		return counter;
	}

	// ��� ������� ������� ������ ������ �� ����� ������� ��������� � �������
	// ���������� ���������� ��������� ����������� � ��� �� ���, ��� � ������
	// (i-��) �������, �� ���� ���������� ���������, ����������� ������ � ���
	public int[] getYearCount() {
		int[] yearCount = new int[this.students.length];
		for (int i = 0; i < this.getStudents().length; i++) {
			for (int j = 0; j < this.getStudents().length; j++) {
				if (this.getStudents()[i].getStartYear() == this.getStudents()[j].getStartYear()) {
					yearCount[i]++;
				}
			}
		}
		return yearCount;
	}

	// ��� ������� ���������� ������������ ���������� ���������,
	// ����������� � ���� ���
	public int getNumberStudentsMaxYear() {
		int[] yearCount = this.getYearCount();
		int number = 0;
		for (int x : yearCount) {
			if (number <= x) {
				number = x;
			}
		}
		return number;
	}

	// ��� ������� ���������� ���, � ������� ��������� ������������ ����������
	// ���������
	public int getYearMaxStudents() {
		int year = 0;
		int counter = 0;
		int[] studCount = this.getYearCount();
		int num = this.getNumberStudentsMaxYear();
		for (int i = 0; i < this.getStudents().length; i++) {
			if (num == studCount[i]) {
				year = this.getStudents()[i].getStartYear();
			}
		}
		return year;
	}
}
package by.htp.Group.runner;

import java.util.Arrays;

import javax.swing.plaf.synth.SynthSeparatorUI;

import by.htp.Group.model.*;

public class MainApp {

	public static void main(String[] args) {

		Student st1 = new Student(18, 2010);
		Student st2 = new Student(19, 2010);
		Student st3 = new Student(18, 2010);
		Student st4 = new Student(20, 2013);
		Student st5 = new Student(21, 2012);
		Student st6 = new Student(22, 2011);
		Student st7 = new Student(18, 2008);
		Student st8 = new Student(23, 2017);
		Student st9 = new Student(25, 2009);
		Student st10 = new Student(26, 2008);
		Student st11 = new Student(21, 2008);
		Student st12 = new Student(22, 2008);
		Student st13 = new Student(23, 2007);
		Student st14 = new Student(23, 2006);
		Student st15 = new Student(18, 2005);
		Student st16 = new Student(18, 2003);

		Group group = new Group();

		if (group.getStudents() == null) {
			System.out.println("null");
		} else {
			System.out.println("not null");
		}

		group.addStudent(st1);
		group.addStudent(st2);
		group.addStudent(st3);
		group.addStudent(st4);
		group.addStudent(st5);
		group.addStudent(st6);
		group.addStudent(st7);
		group.addStudent(st8);
		group.addStudent(st9);
		group.addStudent(st10);
		group.addStudent(st11);
		group.addStudent(st12);
		// group.addStudent(st13);
		// group.addStudent(st14);
		// group.addStudent(st15);
		// group.addStudent(st16);

		System.out.println("В группе учится = " + group.getStudents().length);

		System.out.println("Средний возраст студентов в группе = " + group.getMedium());

		group.getStudentsNumberByStartDate();

		System.out.println("Больше всего студентов поступило в " + group.getYearMaxStudents()
				+ " году, их количество равно " + group.getNumberStudentsMaxYear());

		group.selectionSort();
		System.out.println("сортировка выбором " + Arrays.toString(group.getStudentsAge()));

		// group.insertionSort();
		// System.out.println("сортировка вставками " +
		// Arrays.toString(group.getStudentsAge()));
	}

}

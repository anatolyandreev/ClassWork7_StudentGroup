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

	// этот метод возвращает массив из возрастов всех студентов
	public int[] getStudentsAge() {
		int[] age = new int[this.getStudents().length];
		for (int i = 0; i < this.getStudents().length; i++) {
			age[i] = this.getStudents()[i].getAge();
		}
		return age;
	}

	public void setStudentAge(int[] age) {
		for (int i = 0; i < this.getStudents().length; i++) {
			this.getStudentsAge()[i] = age[i];
		}
	}

	// эта функция проверяет достаточно ли студентов в группе (больше или меньше
	// 5ти)
	// чтобы начать обучение
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
			System.out.println("В группе меньше 5-ти студентов, добавьте студентов");
		} else {
			System.out.println("В группе 5 или больше студентов можно начинать обучение");
		}
		return status;
	}

	// эта функция добавляет студентов в группу
	// изначально создается "пустая" групп на 5 мест
	// присутствует warning на то, что необходимо добавить студента в группу
	// если количество занятых мест в группе меньше 5
	// присутствует проверка на чтобы количество стунентов в группе не превышало
	// 15 человек
	// таким образом 16-й студент в группу добавлен не будет
	public void addStudent(Student student) {
		if (this.students != null) {
			if (students.length == 15) {
				System.out.println("Количество людей в группе не может быть больше 15-ти");
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

	// эта функция возвращает средний возраст студентов в группе
	public double getMedium() {
		double medium = 0;
		int sum = 0;
		for (int i = 0; i < students.length; i++) {
			sum += students[i].getAge();
			medium = (double) sum / students.length;
		}
		return medium;
	}

	// эта функция возвращает количество студентов, поступивших в заданном году
	// заданный год вводится с консоли
	public int getStudentsNumberByStartDate() {
		int counter = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите год");
		int year = sc.nextInt();
		for (Student student : students) {
			if (student.getStartYear() == year) {
				counter++;
			}
		}
		System.out.println("Количество студентов, поступивших в " + year + " году = " + counter);
		return counter;
	}

	// эта функция создает массив равный по длине массиву студентов в котором
	// содержится количество студентов поступивших в тот же год, что и данный
	// (i-ый) студент, то есть количество студентов, поступивших вместе с ним
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

	// эта функция возвращает максимальное количество студентов,
	// поступивших в один год
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

	// эта функция возвращает год, в который поступило максимальное количество
	// студентов
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

	// сортировка списка студентов по возрасту в взрастающем порядке
	public void bubbleSortAsc() {
		for (int i = this.getStudents().length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (this.getStudents()[j].getAge() > this.getStudents()[j + 1].getAge()) {
					Student temp = this.getStudents()[j + 1];
					this.getStudents()[j + 1] = this.getStudents()[j];
					this.getStudents()[j] = temp;
				}
			}
		}
	}

	// сортировка вставками в взрастающем порядке
	public void insertionSort() {
		int j, tempInt;
		Student temp;
		for (int i = 0; i < this.getStudents().length - 1; i++) {
			if (this.getStudentsAge()[i] > getStudentsAge()[i + 1]) {
				temp = this.getStudents()[i + 1];
				tempInt = this.getStudentsAge()[i + 1];
				this.getStudents()[i + 1] = this.getStudents()[i];
				j = i;
				while (j > 0 && tempInt < this.getStudentsAge()[j - 1]) {
					this.getStudents()[j] = this.getStudents()[j - 1];
					j--;
				}
			}
		}
	}

	// сортировка выбором в возрастающем порядке
	public void selectionSort() {
		int min, imin;
		Student temp;
		//int[] tempAge = new int[this.students.length];
		for (int i = 0; i < this.students.length; i++) {
			imin = i;
			min = this.getStudents()[i].getAge();
			for (int j = i + 1; j < this.students.length; j++) {
				if (this.students[j].getAge() < min) { // min or this.getStudentsAge()[imin]
					min = this.students[j].getAge();
					imin = j;
				}
			}
			// Swap the values
			if (i != imin && this.students[i] != null) {
				temp = this.getStudents()[i]; // [imin]
				this.students[i] = this.students[imin]; //
				this.students[imin] = temp;
			}
		}
	}
	
	// быстрая сортировка
	public void quickSort(int low, int high) {
//		int low = 0;
//		int high = students.length - 1;
		
		
        if (this.getStudentsAge().length == 0)
            return;//завершить выполнение если длина массива равна 0
 
        if (low >= high)
            return;//завершить выполнение если уже нечего делить
 
        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = this.getStudentsAge()[middle];
 
        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (this.getStudentsAge()[i] < opora) {
                i++;
            }
 
            while (this.getStudentsAge()[j] > opora) {
                j--;
            }
 
            if (i <= j) {//меняем местами
                Student temp = this.getStudents()[i];
                this.getStudents()[i] = this.getStudents()[j];
                this.getStudents()[j] = temp;
                i++;
                j--;
            }
        }
 
        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            this.quickSort(low, j);
 
        if (high > i)
            this.quickSort(i, high);
    }
}

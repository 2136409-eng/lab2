package lab9;

import java.util.Arrays;

public class Student {
    private int iDNumber;
    private double gpa;

    public Student(int iDNumber, double gpa) {
        this.iDNumber = iDNumber;
        this.gpa = gpa;
    }

    public int getIDNumber() {
        return iDNumber;
    }

    public double getGPA() {
        return gpa;
    }

    @Override
    public String toString() {
        return "ID: " + iDNumber + ", итоговый балл: " + gpa;
    }

    // Сортировка вставками по ID
    public static void insertionSort(Student[] students) {
        for (int i = 1; i < students.length; i++) {
            Student current = students[i];
            int j = i - 1;

            while (j >= 0 &&
                    students[j].getIDNumber() > current.getIDNumber()) {
                students[j + 1] = students[j];
                j--;
            }

            students[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student(104, 4.2),
                new Student(101, 4.8),
                new Student(105, 3.7),
                new Student(102, 4.5),
                new Student(103, 4.0)
        };

        System.out.println("До сортировки:");
        System.out.println(Arrays.toString(students));

        insertionSort(students);

        System.out.println("После сортировки по ID:");
        System.out.println(Arrays.toString(students));
    }
}
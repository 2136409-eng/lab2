package lab9;

import java.util.Arrays;
import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return Double.compare(student2.getGPA(), student1.getGPA());
    }

    public static void quickSort(Student[] students, int low, int high) {
        if (low >= high) {
            return;
        }

        int i = low;
        int j = high;
        double pivot = students[(low + high) / 2].getGPA();

        while (i <= j) {
            while (students[i].getGPA() > pivot) {
                i++;
            }

            while (students[j].getGPA() < pivot) {
                j--;
            }

            if (i <= j) {
                Student temp = students[i];
                students[i] = students[j];
                students[j] = temp;

                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(students, low, j);
        }

        if (i < high) {
            quickSort(students, i, high);
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

        quickSort(students, 0, students.length - 1);

        System.out.println("После сортировки по убыванию GPA:");
        System.out.println(Arrays.toString(students));
    }
}
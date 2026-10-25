package lab10;

import java.util.Arrays;
import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {

    private Student[] iDNumber;

    @Override
    public int compare(Student student1, Student student2) {
        return Double.compare(student2.getGPA(), student1.getGPA());
    }

    public void setArray() {
        iDNumber = new Student[]{
                new Student("Анна", "Иванова", "Информатика", 2, "ИВТ-21", 4.8),
                new Student("Иван", "Петров", "Математика", 1, "МАТ-11", 4.2),
                new Student("Мария", "Сидорова", "Информатика", 3, "ИВТ-31", 4.9),
                new Student("Алексей", "Смирнов", "Физика", 2, "ФИЗ-21", 3.9),
                new Student("Елена", "Кузнецова", "Математика", 1, "МАТ-12", 4.5)
        };
    }

    public void outArray() {
        for (Student student : iDNumber) {
            System.out.println(student);
        }
    }

    public static void quicksort(Student[] students, int low, int high,
                                 Comparator<Student> comparator) {
        if (low >= high) {
            return;
        }

        int i = low;
        int j = high;
        Student pivot = students[(low + high) / 2];

        while (i <= j) {
            while (comparator.compare(students[i], pivot) < 0) {
                i++;
            }

            while (comparator.compare(students[j], pivot) > 0) {
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
            quicksort(students, low, j, comparator);
        }

        if (i < high) {
            quicksort(students, i, high, comparator);
        }
    }

    public static void mergeSort(Student[] students,
                                 Comparator<Student> comparator) {
        if (students.length < 2) {
            return;
        }

        int middle = students.length / 2;

        Student[] left = Arrays.copyOfRange(students, 0, middle);
        Student[] right = Arrays.copyOfRange(
                students, middle, students.length);

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        merge(left, right, students, comparator);
    }

    private static void merge(Student[] left, Student[] right,
                              Student[] result,
                              Comparator<Student> comparator) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (comparator.compare(left[i], right[j]) <= 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    public void sortBySurname() {
        Arrays.sort(iDNumber, Comparator.comparing(Student::getSurname));
    }

    public static Student[] mergeStudentLists(Student[] first,
                                              Student[] second,
                                              Comparator<Student> comparator) {
        Student[] result = new Student[first.length + second.length];

        merge(first, second, result, comparator);

        return result;
    }

    public static void main(String[] args) {
        SortingStudentsByGPA tester = new SortingStudentsByGPA();
        tester.setArray();

        System.out.println("Исходный список:");
        tester.outArray();

        quicksort(tester.iDNumber, 0,
                tester.iDNumber.length - 1, tester);

        System.out.println("\nСортировка быстрой сортировкой по среднему баллу:");
        tester.outArray();

        tester.setArray();
        mergeSort(tester.iDNumber, tester);

        System.out.println("\nСортировка слиянием по среднему баллу:");
        tester.outArray();

        tester.sortBySurname();

        System.out.println("\nСортировка по фамилии:");
        tester.outArray();

        Student[] first = {
                new Student("Анна", "Иванова", "Информатика", 2, "ИВТ-21", 4.8),
                new Student("Иван", "Петров", "Математика", 1, "МАТ-11", 4.2)
        };

        Student[] second = {
                new Student("Мария", "Сидорова", "Информатика", 3, "ИВТ-31", 4.9),
                new Student("Елена", "Кузнецова", "Математика", 1, "МАТ-12", 4.5)
        };

        mergeSort(first, tester);
        mergeSort(second, tester);

        Student[] combined = mergeStudentLists(first, second, tester);

        System.out.println("\nОбъединение двух отсортированных списков:");
        for (Student student : combined) {
            System.out.println(student);
        }
    }
}

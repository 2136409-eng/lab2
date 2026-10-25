package lab11;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String name;
    private String surname;
    private String specialty;
    private int course;
    private String group;
    private double gpa;
    private Date birthDate;

    public Student(String name, String surname, String specialty,
                   int course, String group, double gpa, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.specialty = specialty;
        this.course = course;
        this.group = group;
        this.gpa = gpa;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSpecialty() {
        return specialty;
    }

    public int getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    public double getGPA() {
        return gpa;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getBirthDate(String formatType) {
        String pattern;

        switch (formatType.toLowerCase()) {
            case "короткий":
                pattern = "dd.MM.yy";
                break;
            case "средний":
                pattern = "dd MMM yyyy";
                break;
            case "полный":
                pattern = "EEEE, dd MMMM yyyy";
                break;
            default:
                pattern = "dd.MM.yyyy";
        }

        return new SimpleDateFormat(pattern).format(birthDate);
    }

    @Override
    public String toString() {
        return "Студент: " + surname + " " + name
                + ", специальность: " + specialty
                + ", курс: " + course
                + ", группа: " + group
                + ", средний балл: " + gpa
                + ", дата рождения: " + getBirthDate("полный");
    }

    public static void main(String[] args) {
        Student student = new Student(
                "Анна", "Иванова", "Информатика",
                2, "ИВТ-21", 4.8,
                new Date(104, 4, 15)
        );

        System.out.println(student);
        System.out.println("Короткий формат: " + student.getBirthDate("короткий"));
        System.out.println("Средний формат: " + student.getBirthDate("средний"));
        System.out.println("Полный формат: " + student.getBirthDate("полный"));
    }
}
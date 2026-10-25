package lab13;

public class Person {
    private String surname;
    private String name;
    private String patronymic;

    public Person(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public String getInitials() {
        StringBuilder result = new StringBuilder();

        if (surname != null && !surname.trim().isEmpty()) {
            result.append(surname.trim());
        }

        if (name != null && !name.trim().isEmpty()) {
            if (result.length() > 0) result.append(" ");
            result.append(name.trim().charAt(0)).append(".");
        }

        if (patronymic != null && !patronymic.trim().isEmpty()) {
            result.append(patronymic.trim().charAt(0)).append(".");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Person person1 = new Person("Иванов", "Иван", "Иванович");
        Person person2 = new Person("Петров", "Анна", null);
        Person person3 = new Person("Сидоров", null, null);

        System.out.println(person1.getInitials());
        System.out.println(person2.getInitials());
        System.out.println(person3.getInitials());
    }
}
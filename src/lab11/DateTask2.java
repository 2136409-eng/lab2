package lab11;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateTask2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите дату и время (дд.мм.гггг чч:мм): ");
        String input = scanner.nextLine();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        format.setLenient(false);

        try {
            Date enteredDate = format.parse(input);
            Date currentDate = new Date();

            System.out.println("Введенная дата: " + format.format(enteredDate));
            System.out.println("Текущая дата: " + format.format(currentDate));

            if (enteredDate.before(currentDate)) {
                System.out.println("Введенная дата раньше текущей.");
            } else if (enteredDate.after(currentDate)) {
                System.out.println("Введенная дата позже текущей.");
            } else {
                System.out.println("Даты совпадают.");
            }
        } catch (Exception e) {
            System.out.println("Неверный формат даты.");
        }

        scanner.close();
    }
}
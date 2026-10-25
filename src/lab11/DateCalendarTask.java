package lab11;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateCalendarTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите год: ");
        int year = scanner.nextInt();

        System.out.print("Введите месяц (1–12): ");
        int month = scanner.nextInt();

        System.out.print("Введите число: ");
        int day = scanner.nextInt();

        System.out.print("Введите часы (0–23): ");
        int hours = scanner.nextInt();

        System.out.print("Введите минуты (0–59): ");
        int minutes = scanner.nextInt();

        Calendar calendar = new GregorianCalendar(
                year, month - 1, day, hours, minutes
        );

        calendar.setLenient(false);

        try {
            Date date = calendar.getTime();

            SimpleDateFormat format =
                    new SimpleDateFormat("dd.MM.yyyy HH:mm");

            System.out.println("Объект Date: " + date);
            System.out.println("Объект Calendar: " + format.format(calendar.getTime()));
        } catch (IllegalArgumentException e) {
            System.out.println("Введена некорректная дата или время.");
        }

        scanner.close();
    }
}
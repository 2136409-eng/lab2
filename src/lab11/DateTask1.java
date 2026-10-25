package lab11;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class DateTask1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите фамилию разработчика: ");
        String surname = scanner.nextLine();

        System.out.print("Введите дату и время получения задания (25.10.2026 чч:мм): ");
        String received = scanner.nextLine();

        Date submissionDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        System.out.println("Разработчик: " + surname);
        System.out.println("Задание получено: " + received);
        System.out.println("Задание сдано: " + format.format(submissionDate));

        scanner.close();
    }
}

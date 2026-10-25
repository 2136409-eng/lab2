package lab14;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexTask7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)"
                + "[A-Za-z\\d_]{8,}$";

        if (Pattern.matches(regex, password)) {
            System.out.println("Пароль надежный.");
        } else {
            System.out.println("Пароль ненадежный.");
        }

        scanner.close();
    }
}
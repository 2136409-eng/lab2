package lab14;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexTask2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String text = scanner.nextLine();

        String regex = "abcdefghijklmnopqrstuv18340";

        System.out.println(Pattern.matches(regex, text)
                ? "Строка правильная."
                : "Строка неправильная.");

        scanner.close();
    }
}
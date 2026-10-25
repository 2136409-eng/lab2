package lab13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordChain {

    public static String getLine(String text) {
        String[] words = text.trim().split("\\s+");

        if (text.trim().isEmpty()) {
            return "";
        }

        boolean[] used = new boolean[words.length];
        StringBuilder result = new StringBuilder();

        result.append(words[0]);
        used[0] = true;

        char lastChar = Character.toLowerCase(
                words[0].charAt(words[0].length() - 1));

        for (int count = 1; count < words.length; count++) {
            boolean found = false;

            for (int i = 0; i < words.length; i++) {
                if (!used[i]
                        && Character.toLowerCase(words[i].charAt(0)) == lastChar) {
                    result.append(" ").append(words[i]);
                    used[i] = true;
                    lastChar = Character.toLowerCase(
                            words[i].charAt(words[i].length() - 1));
                    found = true;
                    break;
                }
            }

            if (!found) {
                return "Не удалось составить цепочку из всех слов.";
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу: ");
        String fileName = scanner.nextLine();

        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            StringBuilder text = new StringBuilder();

            while (fileScanner.hasNext()) {
                text.append(fileScanner.next()).append(" ");
            }

            System.out.println(getLine(text.toString()));
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }

        scanner.close();
    }
}
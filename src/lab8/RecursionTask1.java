package lab8;

import java.util.Scanner;

public class RecursionTask1 {
    public static void printSequence(int n, int number, int count) {
        if (n == 0) {
            return;
        }

        if (count == number) {
            System.out.print(number + " ");
            printSequence(n - 1, number + 1, 1);
        } else {
            System.out.print(number + " ");
            printSequence(n - 1, number, count + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите n:");
        int n = scanner.nextInt();

        printSequence(n, 1, 1);
    }
}
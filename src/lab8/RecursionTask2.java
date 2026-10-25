package lab8;

import java.util.Scanner;

public class RecursionTask2 {
    public static void printNumbers(int n) {
        if (n == 0) {
            return;
        }

        printNumbers(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите n:");
        int n = scanner.nextInt();

        printNumbers(n);
    }
}
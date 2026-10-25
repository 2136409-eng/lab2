package lab8;

import java.util.Scanner;

public class RecursionTask3 {
    public static void printNumbers(int a, int b) {
        if (a == b) {
            System.out.print(a + " ");
            return;
        }

        System.out.print(a + " ");

        if (a < b) {
            printNumbers(a + 1, b);
        } else {
            printNumbers(a - 1, b);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите A:");
        int a = scanner.nextInt();

        System.out.println("Введите B:");
        int b = scanner.nextInt();

        printNumbers(a, b);
    }
}

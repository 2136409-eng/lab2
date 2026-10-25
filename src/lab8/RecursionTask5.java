package lab8;

import java.util.Scanner;

public class RecursionTask5 {
    public static int sumDigits(int n) {
        if (n < 10) {
            return n;
        }

        return n % 10 + sumDigits(n / 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите натуральное число N:");
        int n = scanner.nextInt();

        System.out.println(sumDigits(n));
    }
}

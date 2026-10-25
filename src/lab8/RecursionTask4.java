package lab8;

import java.util.Scanner;

public class RecursionTask4 {
    public static int countNumbers(int k, int s) {
        if (k == 0) {
            return s == 0 ? 1 : 0;
        }

        int count = 0;
        int start = (k == 1) ? 1 : 0;

        for (int digit = start; digit <= 9; digit++) {
            if (s >= digit) {
                count += countNumbers(k - 1, s - digit);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество цифр k:");
        int k = scanner.nextInt();

        System.out.println("Введите сумму цифр s:");
        int s = scanner.nextInt();

        System.out.println(countNumbers(k, s));
    }
}

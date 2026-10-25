package lab14;

import java.util.Arrays;

public class RegexTask8 {

    public static Object[] filter(Object[] array, Filter filter) {
        int count = 0;

        for (Object item : array) {
            if (filter.apply(item)) {
                count++;
            }
        }

        Object[] result = new Object[count];
        int index = 0;

        for (Object item : array) {
            if (filter.apply(item)) {
                result[index++] = item;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Object[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Object[] evenNumbers = filter(numbers, o ->
                o instanceof Integer && (Integer) o % 2 == 0);

        System.out.println("Четные числа: "
                + Arrays.toString(evenNumbers));

        Object[] words = {"Java", "", "Hello", " ", "World"};

        Object[] nonEmptyWords = filter(words, o ->
                o instanceof String && !((String) o).trim().isEmpty());

        System.out.println("Непустые строки: "
                + Arrays.toString(nonEmptyWords));
    }
}
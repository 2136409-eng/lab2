package lab13;

public class StringTask {
    public static void processString(String str) {
        System.out.println("Последний символ: " + str.charAt(str.length() - 1));
        System.out.println("Заканчивается на !!!: " + str.endsWith("!!!"));
        System.out.println("Начинается с I like: " + str.startsWith("I like"));
        System.out.println("Содержит Java: " + str.contains("Java"));
        System.out.println("Позиция Java: " + str.indexOf("Java"));
        System.out.println("Замена а на о: " + str.replace('a', 'o'));
        System.out.println("В верхнем регистре: " + str.toUpperCase());
        System.out.println("В нижнем регистре: " + str.toLowerCase());

        int start = str.indexOf("Java");
        if (start != -1) {
            System.out.println("Вырезанная Java: "
                    + str.substring(start, start + 4));
        }
    }

    public static void main(String[] args) {
        processString("I like Java!!!");
    }
}
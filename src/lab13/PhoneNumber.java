package lab13;

public class PhoneNumber {
    public static String format(String phone) {
        phone = phone.replaceAll("[\\s()-]", "");

        if (phone.matches("8\\d{10}")) {
            phone = "+7" + phone.substring(1);
        } else if (phone.matches("\\d{10}")) {
            phone = "+7" + phone;
        } else if (!phone.matches("\\+\\d{11,12}")) {
            throw new IllegalArgumentException("Неверный формат номера.");
        }

        String countryCode = phone.substring(0, phone.length() - 10);
        String number = phone.substring(phone.length() - 10);

        return countryCode + number.substring(0, 3) + "-"
                + number.substring(3, 6) + "-"
                + number.substring(6);
    }

    public static void main(String[] args) {
        System.out.println(format("+79175655655"));
        System.out.println(format("+104289652211"));
        System.out.println(format("89175655655"));
    }
}
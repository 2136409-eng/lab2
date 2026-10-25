package lab13;

import java.util.StringTokenizer;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String building;
    private String apartment;

    public void parseWithSplit(String address) {
        String[] parts = address.split(",", -1);
        setFields(parts);
    }

    public void parseWithTokenizer(String address) {
        StringTokenizer tokenizer = new StringTokenizer(address, ",.;-");
        String[] parts = new String[tokenizer.countTokens()];

        for (int i = 0; i < parts.length; i++) {
            parts[i] = tokenizer.nextToken();
        }

        setFields(parts);
    }

    private void setFields(String[] parts) {
        if (parts.length != 7) {
            throw new IllegalArgumentException(
                    "Адрес должен содержать ровно 7 частей.");
        }

        country = parts[0].trim();
        region = parts[1].trim();
        city = parts[2].trim();
        street = parts[3].trim();
        house = parts[4].trim();
        building = parts[5].trim();
        apartment = parts[6].trim();
    }

    @Override
    public String toString() {
        return "Страна: " + country
                + "\nРегион: " + region
                + "\nГород: " + city
                + "\nУлица: " + street
                + "\nДом: " + house
                + "\nКорпус: " + building
                + "\nКвартира: " + apartment;
    }

    public static void main(String[] args) {
        String[] addresses = {
                "Россия, Московская область, Москва, Тверская, 10, 2, 15",
                "Россия; Ленинградская область; Санкт-Петербург; Невский; 20; 1; 30",
                "Беларусь. Минская область. Минск. Ленина. 5. 1. 12",
                "Россия, Татарстан, Казань, Баумана, 7, 3, 25"
        };

        Address address = new Address();

        for (int i = 0; i < addresses.length; i++) {
            System.out.println("\nАдрес " + (i + 1) + ":");

            try {
                if (i == 0 || i == 3) {
                    address.parseWithSplit(addresses[i]);
                } else {
                    address.parseWithTokenizer(addresses[i]);
                }

                System.out.println(address);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
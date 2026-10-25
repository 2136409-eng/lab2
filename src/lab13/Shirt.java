package lab13;

public class Shirt {
    private String id;
    private String name;
    private String color;
    private String size;

    public Shirt(String id, String name, String color, String size) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Артикул: " + id
                + "\nНазвание: " + name
                + "\nЦвет: " + color
                + "\nРазмер: " + size;
    }
}
package exercises;

public class Rectangle extends Shape {

    private Double length;
    private Double width;

    public Rectangle(String name, Double length, Double width) {
        super(name);
        this.length = length;
        this.width = width;
    }

    @Override
    public Double calculateArea() {
        return length * width;
    }

}

package exercises;

public class Circle extends Shape {

    private Double radius;

    public Circle(String name, Double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

}

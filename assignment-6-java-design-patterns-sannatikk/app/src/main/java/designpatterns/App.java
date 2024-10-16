package designpatterns;

public class App {

    public static void main(String[] args) {
        System.out.println("Main does something!");

        Calculator cb = new Calculator(5.0);  // Initial value 5.0
        Double result = cb.add(2.0)
                         .multiply(2.0)
                         .subtract(2.5)
                         .getResult();

        System.out.println("Result: " + result);  // Output: 11.5

        // Creating a circle with radius 5.0
        Shape circle = ShapeFactory.create("circle", new Double[] { 5.0 });
        System.out.println("Circle area: " + circle.getArea());  // Output: Circle area: 78.53981633974483
        
        // Creating a rectangle with width 4.0 and length 6.0
        Shape rectangle = ShapeFactory.create("rectangle", new Double[] { 4.0, 6.0 });
        System.out.println("Rectangle area: " + rectangle.getArea());  // Output: Rectangle area: 24.0
    }
}

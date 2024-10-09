package oop;

/*
The subclass Circle similarly inherits the Shape class and additionally has

Private attribute radius, type is Double

Constructor needed to set name and radius. Remember to call superclass constructor here!

Overridden method Double getArea that returns the area as pi*radius*radius
 */

public class Circle extends Shape {

    private Double radius;

    public Circle(String name, Double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public Double getArea() {
        return Math.PI * radius * radius;
    }

}

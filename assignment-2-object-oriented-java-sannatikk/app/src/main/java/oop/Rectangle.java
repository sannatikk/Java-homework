package oop;

/*
 The subclass Rectangle class inherits all of the above from Shape and additionally has

Private attributes width and height, both of type Double

Constructor is needed to initialize values into name, width and height. Remember to call superclass constructor here!

Overridden method Double getArea that returns the area as width * height
*/

public class Rectangle extends Shape{
    
    private Double width;
    private Double height;

    public Rectangle(String name, Double width, Double height){
        super(name);
        this.width = width;
        this.height = height;
    }

    @Override
    public Double getArea(){
        return width * height;
    }

}

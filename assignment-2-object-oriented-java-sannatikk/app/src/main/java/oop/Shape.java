package oop;

/*
The Shape class has

Protected attribute String name

Constructor with parameter String name, which initializes the member variable

Method Double getArea that returns the shape area. This should by default return the value 0.0

Overridden method String toString from the Object class, that returns the member variable name 
 */

public class Shape {

    protected String name;

    public Shape(String name){
        this.name = name;
    }

    public Double getArea(){
        return 0.0;
    }

    @Override
    public String toString(){
        return name;
    }

}

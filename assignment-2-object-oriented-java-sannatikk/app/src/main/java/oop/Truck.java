package oop;

/*
Create class Truck that inherits the class Vehicle

Remember to add keyword extends in the class declaration. Its not there by default.

Constructor has 4 parameters: String name, String model, Integer year and Double distanceDriven.

In the constructor, you need to call the superclass constructor with the distanceDriven parameter!

For the Truck class create method getDetails that return the truck details as String consisting of member variables name model year

The key idea here is to use the existing data and methods of the parent class Vehicle. The idea is not to rewrite those into the child class. This would break the whole idea of inheritance in OOP..
*/

public class Truck extends Vehicle {

    private String name;
    private String model;
    private Integer year;

    public Truck(String name, String model, Integer year, Double distanceDriven) {
        super(distanceDriven);
        this.name = name;
        this.model = model;
        this.year = year;
        }

    public String getDetails(){
        return year + " " + name + " " + model;
    }
    }

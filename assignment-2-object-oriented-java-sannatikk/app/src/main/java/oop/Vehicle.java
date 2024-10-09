package oop;

/*
Create Java class Vehicle, that has

Private member variable fuelUsed that is type Double. This stores how much fuel the vehicle has used.

Private member variable distanceDriven that is type Double that stores how many kilometers the vehicle has driven.

Constructor with parameter that initializes the member variable distanceDriven

Getters and setters for the variables fuelUsed and distanceDriven

Public method getFuelConsumption that returns the fuel consumption as liters per 100km (fuelUsed / distanceDriven * 100) with return type Double
*/

public class Vehicle {

    private Double fuelUsed;
    private Double distanceDriven;

    public Vehicle(Double distance) {
        this.distanceDriven = distance;
    }

    public Double getFuelUsed() {
        return fuelUsed;
    }

    public void setFuelUsed(Double fuel) {
        this.fuelUsed = fuel;
    }

    public Double getDistanceDriven() {
        return distanceDriven;
    }

    public void setDistanceDriven(Double distance) {
        this.distanceDriven = distance;
    }

    public Double getFuelConsumption() {
        return fuelUsed / distanceDriven * 100;
    }

}

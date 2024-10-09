package oop;

/*
Create a class called Apartment based on the UML class diagram in the repository

Pay attention to the access modifiers for each member variable or method

As you see, contructor with two parameters is needed: the number of tenants as the 1st parameter and the area of the apartment as the 2nd parameter.

Add method heatingCost which takes the electricity price kw/h as parameter of type Float. Method calculates the heating as numOfTenants * area * price and returns it. 
*/

class Apartment {

    private Integer numOfTenants;
    private Integer area;

    public Apartment (Integer ten, Integer ar) {
        this.numOfTenants = ten;
        this.area = ar;
    }

    public Float heatingCost(Float price) {
        return numOfTenants * area * price;
    }


}

package exercises;

// create an abstract class named Shape

abstract class Shape {
    
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public abstract Double calculateArea();
    
}
package designpatterns;

public class Circle implements Shape {

    private Double radius;

    public Circle (Double[] params){
        if(params == null || params.length != 1){
            throw new IllegalArgumentException("Number of parameters wrong for circle, needs radius");
        }
        if(params[0] == null){
            throw new IllegalArgumentException("Radius cannot be null");
        }
        this.radius = params[0];
    }

    @Override
    public Double[] getParams() {
        return new Double[]{radius};
    }

    @Override
    public Double getArea() {
        return Math.PI * radius * radius;
    }

}

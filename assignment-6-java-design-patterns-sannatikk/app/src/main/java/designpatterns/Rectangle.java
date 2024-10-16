package designpatterns;

public class Rectangle implements Shape {

    private Double width;
    private Double length;

    public Rectangle (Double[] params){
        if(params == null || params.length != 2){
            throw new IllegalArgumentException("Number of parameters wrong for rectangle, needs width and length");
        }
        if(params[0] == null || params[1] == null){
            throw new IllegalArgumentException("Width or length cannot be null");
        }
        this.width = params[0];
        this.length = params[1];
    }

    @Override
    public Double[] getParams() {
        return new Double[]{width, length};
    }

    @Override
    public Double getArea() {
        return width * length;
    }

}

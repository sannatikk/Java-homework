package designpatterns;

public class ShapeFactory {
    
    private ShapeFactory(){}

    public static Shape create(String type, Double[] params) {
        if(type == null){
            throw new IllegalArgumentException("Type cannot be null");
        }
        if(params == null){
            throw new IllegalArgumentException("Params cannot be null");
        }
        if(type.equalsIgnoreCase("circle")){
            return new Circle(params);
        } else if(type.equalsIgnoreCase("rectangle")){
            return new Rectangle(params);
        } else {
            throw new IllegalArgumentException("Invalid shape type: " +type+ ". Supported types are circle and rectangle");
        }
    }

}

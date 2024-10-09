package exercises;

public class Product {

    private Double price;
    private Integer quantity;
    private String name;

    public Product(Double price, Integer quantity, String name) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Double getTotal(){
        return price * quantity;
    }

}

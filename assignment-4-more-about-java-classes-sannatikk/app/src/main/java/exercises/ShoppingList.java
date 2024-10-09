package exercises;
import java.util.LinkedList;

public class ShoppingList implements Searchable {

    private LinkedList<Product> shoppingList;

    public ShoppingList(){
        shoppingList = new LinkedList<Product>();
    }

    public ShoppingList(String name, Double price, Integer quantity){
        shoppingList = new LinkedList<Product>();
        shoppingList.add(new Product(price, quantity, name));
    }

    @Override
    public Double getTotalByName(String name){
        // Calculate the total price of all items with a specific name

        Double total = 0.0;

        for (Product thing : shoppingList){
            if (thing.getName().contains(name)){
                total += thing.getTotal();
            }
        }

        return total;
    }

    @Override
    public LinkedList<Product> searchByName(String name){
        // Return a list of all items containing the given name
        LinkedList<Product> result = new LinkedList<Product>();

        for(Product thing : shoppingList){
            if(thing.getName().contains(name)){
                result.add(thing);
            }
        }

        return result;
    }

    @Override
    public LinkedList<Product> searchSmaller(Double value){
        // Return a list of all items whose price is smaller than the given value
    
        LinkedList<Product> result = new LinkedList<Product>();

        for(Product thing : shoppingList){
            if(thing.getTotal() < value){
                result.add(thing);
            }
        }

        return result;
    
    }

    @Override
    public LinkedList<Product> searchGreaterOrEqual(Double value){
        // Return a list of all items whose price is greater or equal to the given value
    
        LinkedList<Product> result = new LinkedList<Product>();

        for(Product thing : shoppingList){
            if(thing.getTotal() >= value){
                result.add(thing);
            }
        }

        return result;
    }

    public void addItem(String name, Double price, Integer quantity){
        
        shoppingList.add(new Product(price, quantity, name));
    }

}

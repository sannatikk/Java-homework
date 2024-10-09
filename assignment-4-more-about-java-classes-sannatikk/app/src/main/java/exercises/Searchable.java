package exercises;
import java.util.LinkedList;

public interface Searchable {
    
    // Method to calculate the total price of all items with a specific name
    Double getTotalByName(String name);

    // Method to return a list of all items containing the given name
    LinkedList<Product> searchByName(String name);

    // Method to return a list of all items whose price is smaller than the given value
    LinkedList<Product> searchSmaller(Double value);

    // Method to return a list of all items whose price is greater or equal to the given value
    LinkedList<Product> searchGreaterOrEqual(Double value);
}

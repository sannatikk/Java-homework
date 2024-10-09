package oamk.stream;

import java.time.LocalDateTime;

public class App {

    // Main method
    public static void main(String[] args) throws Exception {
        System.out.println("Main does something");

        // Create a new Stock object
        Stock stock = new Stock();
        // Create a new Product object
        Product product = new Product("milk", 1.0, "dairy", LocalDateTime.of(2021, 12, 31, 23, 59));
        // Add the product to the stock
        stock.addProduct(product);
        // create a new Product object
        Product product2 = new Product("bread", 2.0, "bakery", LocalDateTime.of(2021, 11, 11, 21, 49));
        // Add the product to the stock
        stock.addProduct(product2);
        // Print the stock
        System.out.println(stock);
        // Create a new LocalDateTime object
        LocalDateTime dt = LocalDateTime.of(2023, 11, 11, 21, 49);
        // check for expired products
        System.out.println(stock.reportExpired(dt));
    }
}

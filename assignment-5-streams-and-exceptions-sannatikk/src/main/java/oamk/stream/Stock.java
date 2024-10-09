package oamk.stream;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.Locale;

public class Stock {

    private List<Product> products = new LinkedList<Product>();
    private LocalDateTime expireTime;
    private DateTimeFormatter stockFormat;

    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> getProducts(){
        return products;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("List of Products\n");
        sb.append("----------------\n");

        for(Product p : products){

            String s = p.formatProduct(stockFormat);
            sb.append(s);
            sb.append("\n");
        }

        sb.append("-> Total products: %d\n".formatted(products.size()));

        double totalPrice = products.stream().mapToDouble(Product::price).sum();
        
        // Locale.US formatoi desimaalierottimen pisteeksi
        String formattedPrice = String.format(Locale.US, "-> Total price: %.2f\n", totalPrice);
        sb.append(formattedPrice);

        return sb.toString();
    }

    public List<Product> reportExpired(LocalDateTime dt) {

        expireTime = dt;
        return products.stream().filter(expireFilter).toList();
    }

    private Predicate<Product> expireFilter = new Predicate<Product>(){
        @Override
        public boolean test(Product p){
            return p.bestBefore().isBefore(expireTime);
        }
    };

}

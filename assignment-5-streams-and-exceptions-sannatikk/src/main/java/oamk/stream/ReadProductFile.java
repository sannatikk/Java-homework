package oamk.stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

public class ReadProductFile {

    private File dataFile;
    private List<Product> products = new LinkedList<Product>();

    public class CSVMissingParameterException extends Exception{
        public CSVMissingParameterException(String message){
            super(message);
        }
    }

    public ReadProductFile(String fileName){

        dataFile = new File(fileName);
        if (!dataFile.exists()) {
            throw new IllegalArgumentException("File " + fileName + " does not exist");
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    // Method to read the CSV file and parse its contents
    public void readCSV() {
        try {
            List<String> lines = Files.readAllLines(dataFile.toPath());
            
            // Iterate over each line in the CSV
            for (int lineNumber = 0; lineNumber < lines.size(); lineNumber++) {
                String line = lines.get(lineNumber);
                String[] parts = line.split(",");
    
                try {
                    // Check for exactly four fields
                    if (parts.length != 4) {
                        throw new CSVMissingParameterException(
                            String.format("Error in %s, skipped line %d: missing parameter", dataFile.getName(), lineNumber + 1)
                        );
                    }
    
                    // Check for empty fields
                    for (String part : parts) {
                        if (part.isEmpty()) {
                            throw new CSVMissingParameterException(
                                String.format("Error in %s, skipped line %d: missing parameter", dataFile.getName(), lineNumber + 1)
                            );
                        }
                    }
    
                    // If the line is valid, create a Product and add it to the products list
                    Product product = new Product(
                        parts[0],                                  // name
                        Double.parseDouble(parts[1]),              // price
                        parts[2],                                  // category
                        LocalDateTime.parse(parts[3])              // bestBefore date
                    );
                    products.add(product);
    
                } catch (CSVMissingParameterException | NumberFormatException | DateTimeParseException e) {
                    // Ensure the error message matches exactly what the test expects
                    System.err.println(e.getMessage());
                    e.printStackTrace(); // Optional: You can print the stack trace for more detailed debugging
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle file read errors
        }
    }
}
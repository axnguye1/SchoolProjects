import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
4125 - Phase 5
partner: Trieu Huynh and Amanda Nguyen
 */
public class ProcessQuery {
    //hashmap for storing data
    private Map<String, Double> data = new HashMap<>();

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please pass a table name with '$ java ProcessQuery.java (tablename)'");
            return;
        }

        String tableName = args[0];
        String fileName = tableName + ".txt";
        System.out.println("File name: " + fileName);

        ProcessQuery processQuery = new ProcessQuery();

        try {
            processQuery.readData(fileName);
            processQuery.findHighestPrice();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readData(String filePath) throws IOException {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(", ");

                if (values.length >= 3) {
                    String itemCode = values[0];
                    String itemName = values[1];
                    double price = parseData(values[2]);

                    // Store item code and price in the HashMap
                    data.put(itemName, price);
                }
            }
        }
    }

//TASK #8 PHASE 5
    //find Highest PRICE
    public void findHighestPrice() {
        String highestPriceItem = null;
        double highestPrice = Double.MIN_VALUE;

        for (Map.Entry<String, Double> entry : data.entrySet()) {
            double price = entry.getValue();
            if (price > highestPrice) {
                highestPrice = price;
                highestPriceItem = entry.getKey();
            }
        }

        if (highestPriceItem != null) {
            System.out.println("Product Name: " + highestPriceItem);
            System.out.println("Price: " + highestPrice);
        } else {
            System.out.println("No item found.");
        }
    }

    // Helper function to parse a string as a double (price)
    private static double parseData(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return 0.0; // Handle parsing error by returning 0.0 (you can choose another default value)
        }
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
// Trieu Huynh and Amanda Nguyen - Phase 6
public class FindInfo{
    private Map<String, String> customerData = new HashMap<>();
    private Map<String, String> addressData = new HashMap<>();
    private Map<String, Integer> lineItemData = new HashMap<>();

    public static void main(String[] args) {
        FindInfo findData = new FindInfo();
        //task 1
        findData.loadCustomerData("customer.txt");
        findData.loadAddressData("address.txt");
        findData.FindCustomers();
        //task 2
        findData.loadLineItemData("lineitem.txt");
        findData.TotalSold();
    }
//parse customer data
    public void loadCustomerData(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length >= 2) {
                    String customerId = parts[0].trim();
                    String customerName = parts[1].trim();
                    customerData.put(customerId, customerName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //parse address data
    public void loadAddressData(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length >= 2) {
                    String customerId = parts[0].trim();
                    String address = parts[1].trim();
                    addressData.put(customerId, address);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //parse order + product data
    public void loadLineItemData(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length >= 3) {
                    String productId = parts[1].trim();
                    int quantitySold = Integer.parseInt(parts[2].trim());
                    lineItemData.put(productId, lineItemData.getOrDefault(productId, 0) + quantitySold);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void FindCustomers() {
        Set<String> customersWithAddresses = new HashSet<>();


        for (String customerId : customerData.keySet()) { // look for customers
            if (addressData.containsKey(customerId)) { // check if there is an address tied to a customer in the map
                customersWithAddresses.add(customerData.get(customerId));
            }
        }
        //output
        System.out.println("Customers with at least 1 address:");
        for (String customerName : customersWithAddresses) {
            System.out.println(customerName);
        }
    }

    public void TotalSold() {
        Map<String, Integer> totalQuantitySold = new HashMap<>();

        //find items
        for (Map.Entry<String, Integer> entry : lineItemData.entrySet()) {
            String productId = entry.getKey();
            int quantitySold = entry.getValue();
            // add products up
            totalQuantitySold.put(productId, totalQuantitySold.getOrDefault(productId, 0) + quantitySold);
        }
        //output
        for (Map.Entry<String, Integer> entry : totalQuantitySold.entrySet()) {
            System.out.println(entry.getKey() + " total sold = " + entry.getValue());
        }
    }

}

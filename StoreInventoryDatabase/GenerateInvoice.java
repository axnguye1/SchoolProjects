import java.sql.*;

public class GenerateInvoice {
	//Trieu Huynh and Amanda Nguyen Phase 9:JDBC

    public static void generateInvoice(String customerId, String orderDate) {
        String oracleURL = "jdbc:oracle:thin:@localhost:1521:Oracle21c";
        String username = "axnguye1";
        String password = "Crew7094";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(oracleURL, username, password);

            // Check if customer exists
            String customerQuery = "SELECT C_NAME FROM CUSTOMER WHERE C_ID = ?";
            try (PreparedStatement customerStatement = connection.prepareStatement(customerQuery)) {
                customerStatement.setString(1, customerId);
                ResultSet customerResult = customerStatement.executeQuery();

                if (!customerResult.next()) {
                    System.out.println("Error: Customer not found for ID: " + customerId);
                    return;
                }
            }

            // Check if there is an order for the customer on a date
            String orderQuery = "SELECT COUNT(*) FROM ORDERS WHERE C_ID = ? AND O_DATE = ?";
            try (PreparedStatement orderStatement = connection.prepareStatement(orderQuery)) {
                orderStatement.setString(1, customerId);
                orderStatement.setString(2, orderDate);
                ResultSet orderCountResult = orderStatement.executeQuery();

                if (!orderCountResult.next() || orderCountResult.getInt(1) == 0) {
                    System.out.println("No invoice to generate for Customer ID: " + customerId);
                    return;
                }
            }

            // Order cursor fetch data
            String detailQuery = "SELECT C.C_NAME, P.P_NAME, LI.L_QUANTITY, P.P_PRICE, LI.L_QUANTITY * P.P_PRICE AS LINE_PRICE " +
                    "FROM LINEITEM LI " +
                    "JOIN ORDERS O ON LI.L_OID = O.O_ID " +
                    "JOIN PRODUCT P ON LI.L_PID = P.P_ID " +
                    "JOIN CUSTOMER C ON O.C_ID = C.C_ID " +
                    "WHERE O.C_ID = ? AND O.O_DATE = TO_DATE(?, 'DD-MON-YY')";

            try (PreparedStatement detailStatement = connection.prepareStatement(detailQuery)) {
                detailStatement.setString(1, customerId);
                detailStatement.setString(2, orderDate);
                ResultSet detailResults = detailStatement.executeQuery();

                // Output Header
                if (detailResults.next()) {
                    String customerName = detailResults.getString("C_NAME");
                    System.out.println(orderDate + " Invoice for " + customerId + ": " + customerName);
                    System.out.println(String.format("%-20s%-10s%-15s%-15s", "Product", "Quantity", "Unit Price", "Total"));
                    System.out.println("--------------------------------------------------");

                    double totalProductCost = 0;

                    do {
                        String product_name = detailResults.getString("P_NAME");
                        int product_quantity = detailResults.getInt("L_QUANTITY");
                        double unit_price = detailResults.getDouble("P_PRICE");
                        double line_price = detailResults.getDouble("LINE_PRICE");

                        System.out.println(String.format("%-20s%-10s%-15s%-15s",
                                product_name, product_quantity, "$" + unit_price, "$" + line_price));

                        totalProductCost += line_price;
                    } while (detailResults.next());

                    // Calculate costs
                    double shippingCost = (totalProductCost >= 35) ? 0 : 10;
                    double totalCost = totalProductCost + shippingCost;

                    // Display totals
                    System.out.println("Total Product Cost: $" + String.format("%10.2f", totalProductCost));
                    System.out.println("Shipping Cost: $" + String.format("%14.2f", shippingCost));
                    System.out.println("Total Due: $" + String.format("%17.2f", totalCost));
                } else {
                    System.out.println("No data found for the given customer ID and order date.");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    // Main method
    public static void main(String[] args) {
        // Error if no parameters entered
        if (args.length < 2) {
            System.out.println("Error: Please use 'java GenerateInvoice [c_ID] [orderDate]'");
            return;
        }
        String customerId = args[0]; // c_id
        String orderDate = args[1]; // order_date
        generateInvoice(customerId, orderDate);
    }
}




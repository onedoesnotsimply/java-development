import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Load MySQL Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Open a connection to the database
        Connection connection;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root","password");

        // Create a statement
        Statement statement = connection.createStatement();

        // Define the query
        String query = "SELECT productname FROM products";

        // Execute query
        ResultSet resultSet = statement.executeQuery(query);

        // Process results
        while (resultSet.next()) {
            String product = resultSet.getString("productname");
            System.out.println(product);
        }

        // Close connection
        connection.close();
    }
}

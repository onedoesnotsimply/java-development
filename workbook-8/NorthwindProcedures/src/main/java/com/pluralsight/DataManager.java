package com.pluralsight;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataManager {
    private DataSource dataSource;

    public DataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void getCustomerOrderHistory(String customerId){
        // Initialize the query
        String query = "{CALL CustOrderHist(?)}";

        // Create the connection and CallableStatement
        try(Connection connection = dataSource.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);){

            // Set parameters
            callableStatement.setString(1, customerId);

            // Execute the query
            try(ResultSet resultSet = callableStatement.executeQuery();){
                // Check for null
                if (resultSet.next()) {
                    do {
                        System.out.println(resultSet.getString("ProductName")+" - "+resultSet.getInt("TOTAL"));
                    } while (resultSet.next());
                } else {
                    System.out.println("No order history found");
                }
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

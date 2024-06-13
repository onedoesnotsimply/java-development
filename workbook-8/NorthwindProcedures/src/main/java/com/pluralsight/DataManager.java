package com.pluralsight;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;

public class DataManager {
    private DataSource dataSource;

    public DataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void getSalesByCategory(String category, int year){
        String query = "{CALL SalesByCategory (?, ?)}";

        try(Connection connection = dataSource.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);){

            callableStatement.setString(1, category);
            callableStatement.setInt(2, year);

            try(ResultSet resultSet = callableStatement.executeQuery();){
                if (resultSet.next()){
                    do{
                        System.out.printf("""
                                Product Name\t%s
                                Total Purchase\t%d
                                ----------------------------
                                """, resultSet.getString(1), resultSet.getInt(2));
                    } while(resultSet.next());
                } else {
                    System.out.println("No sales found");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getSalesByYear(LocalDate startDate, LocalDate endDate){
        String query = "{CALL `Sales by Year` (?, ?)}";

        try(Connection connection = dataSource.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);){

            callableStatement.setDate(1, Date.valueOf(startDate));
            callableStatement.setDate(2, Date.valueOf(endDate));

            // Execute the query
            try(ResultSet resultSet = callableStatement.executeQuery();){
                // Check for null
                if (resultSet.next()) {
                    do {
                        System.out.printf("""
                                Shipped Date\t%s
                                Order ID\t%d
                                Subtotal\t%.2f
                                Year\t%s
                                ----------------------------
                                """,resultSet.getDate(1), resultSet.getInt(2),
                                resultSet.getDouble(3), resultSet.getDate(4));
                    } while (resultSet.next());

                } else {
                    System.out.println("No sales found");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
                        System.out.printf("""
                                Product Name\t%s
                                Total\t%d
                                ----------------------------
                                """,resultSet.getString("ProductName"),resultSet.getInt("TOTAL"));
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

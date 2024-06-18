package com.pluralsight.NorthwindTradersSpringBoot.Services;

import com.pluralsight.NorthwindTradersSpringBoot.dao.ProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao {
    private DataSource dataSource;

    @Autowired
    public JdbcProductDao (DataSource dataSource){
        // the dataSource is injected from the Config class
        this.dataSource=dataSource;
    }

    @Override
    public void persistProduct(Product product) {
        // Insert
        String insert = "INSERT INTO products (productname, categoryid, unitprice) VALUES (?,?,?)";
        // Select (to get the category id number
        String query = "SELECT categoryid FROM categories WHERE categoryname = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(insert);
            PreparedStatement preparedStatement2 = connection.prepareStatement(query);){

            // Start by getting the needed information
            preparedStatement2.setString(1, product.getCategory());

            try(ResultSet resultSet = preparedStatement2.executeQuery()) {
                if (resultSet.next()){
                    do {
                        //preparedStatement1.setInt(1, product.getProductId());
                        preparedStatement1.setString(1, product.getName());
                        preparedStatement1.setString(2, resultSet.getString("categoryid"));
                        preparedStatement1.setDouble(3,product.getPrice());

                        int rows = preparedStatement1.executeUpdate();
                        if (rows > 0){
                            System.out.println("Product added successfully");
                        }
                    } while (resultSet.next());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //return 0;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();

        String query = "SELECT productid, productname, categoryname, unitprice FROM " +
                "products JOIN categories ON (products.categoryid = categories.categoryid) " +
                "ORDER BY productid";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery();){

            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String cat = resultSet.getString(3);
                double price = resultSet.getDouble(4);

                Product product = new Product(id,name,cat,price);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void deleteProduct(Product product) {
        String delete = "DELETE FROM products WHERE productid = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(delete);){

            preparedStatement.setInt(1,product.getProductId());

            int rows = preparedStatement.executeUpdate();
            if (rows>0) {
                System.out.println("Product removed successfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.pluralsight.NorthwindTradersAPI.DAO;

import com.pluralsight.NorthwindTradersAPI.Model.Product;
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
    public Product insertProduct(Product product) {
        String query = "INSERT INTO products (productname, categoryid, unitprice) VALUES (?,?,?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);){

            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setInt(2,product.getCategoryId());
            preparedStatement.setDouble(3,product.getUnitPrice());

            int rows = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT productid, productname, categoryid, unitprice FROM products";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();){

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String productName = resultSet.getString(2);
                int catId = resultSet.getInt(3);
                double price = resultSet.getDouble(4);

                Product product = new Product(id,productName,catId,price);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void deleteProduct(int id) {
        String query = "DELETE FROM products WHERE productid = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);){

            preparedStatement.setInt(1,id);

            int rows = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateProduct(int id, Product product) {
        String query = "UPDATE products SET productname = ?, categoryid = ?, unitprice = ? WHERE productid = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);){

            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2,product.getCategoryId());
            preparedStatement.setDouble(3,product.getUnitPrice());
            preparedStatement.setInt(4,id);

            int rows = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Product getProductById(int searchId) {
        Product product = null;

        String query = "SELECT productid, productname, categoryid, unitprice FROM products WHERE productid = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);){

            preparedStatement.setInt(1, searchId);

            try(ResultSet resultSet = preparedStatement.executeQuery();){
                if (resultSet.next()){
                    do {
                        product = new Product(resultSet.getInt(1),resultSet.getString(2),
                                resultSet.getInt(3),resultSet.getDouble(4));
                    } while (resultSet.next());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }
}
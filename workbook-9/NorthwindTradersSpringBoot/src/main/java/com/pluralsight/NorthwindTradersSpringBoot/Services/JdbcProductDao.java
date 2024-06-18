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
    public int persistProduct(Product product) {
        return 0;
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
}

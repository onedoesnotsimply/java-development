package com.pluralsight.NorthwindTradersAPI.DAO;

import com.pluralsight.NorthwindTradersAPI.Model.Category;
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
public class JdbcCategoryDao implements CategoryDao {
    private DataSource dataSource;

    @Autowired
    public JdbcCategoryDao(DataSource dataSource){
        this.dataSource=dataSource;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT categoryid, categoryname FROM categories";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();){

            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);

                Category category = new Category(id,name);
                categories.add(category);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    @Override
    public Category getById(int searchId) {
        Category category = null;

        String query = "SELECT categoryid, categoryname FROM categories WHERE categoryid = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);){

            preparedStatement.setInt(1, searchId);

            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);

                    category = new Category(id,name);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return category;
    }

    @Override
    public Category insertCategory(Category category) {
        String query = "INSERT INTO categories (categoryname) VALUES (?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);){

            preparedStatement.setString(1, category.getCategoryName());

            int rows = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return category;
    }

    @Override
    public void updateCategory(int id, Category category) {
        String query = "UPDATE categories SET categoryname = ? WHERE categoryid = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);){

            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.setInt(2,id);

            int rows = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCategory(int id) {
        String query = "DELETE FROM categories WHERE categoryid = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);){

            preparedStatement.setInt(1,id);

            int rows = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

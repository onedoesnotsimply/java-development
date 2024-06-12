package com.pluralsight;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShippersDao {
    private DataSource dataSource;

    public ShippersDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void deleteShipper(int id) {
        String query = "DELETE FROM shippers WHERE shipperid = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);){

            preparedStatement.setInt(1, id);

            int rows = preparedStatement.executeUpdate();

            System.out.printf("Rows deleted %d\n",rows);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateShipper(int id, String phone) {
        String query = "UPDATE shippers SET phone = ? WHERE shipperid = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);){

            preparedStatement.setString(1, phone);
            preparedStatement.setInt(2, id);

            int rows = preparedStatement.executeUpdate();

            System.out.printf("Rows updated %d\n",rows);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertShipper(String companyName, String phone){
        String query = "INSERT INTO shippers (companyname, phone) VALUES (?,?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {

            preparedStatement.setString(1, companyName);
            preparedStatement.setString(2, phone);

            int rows = preparedStatement.executeUpdate();

            System.out.printf("Rows updated %d\n",rows);

            try(ResultSet keys = preparedStatement.getGeneratedKeys();){
                while (keys.next()){
                    System.out.printf("ID# %d added",keys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Shipper> getAllShippers(){
        List<Shipper> shippers = new ArrayList<>();

        String query = "SELECT * FROM shippers";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();){

            if (resultSet.next()){
                do {
                    int id = resultSet.getInt(1);
                    String companyName = resultSet.getString(2);
                    String phone = resultSet.getString(3);

                    Shipper shipper = new Shipper(id,companyName,phone);
                    shippers.add(shipper);
                } while (resultSet.next());
            }
            return shippers;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

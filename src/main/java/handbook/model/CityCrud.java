package handbook.model;

import handbook.jdbc.H2JDBC;
import handbook.jdbc.H2JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityCrud implements H2JDBC<City> {

    public static List<City> cities = new ArrayList<>();

    @Override
    public void creatTable() {
        System.out.println(CityQuery.CREATE_TABLE_SQL);
        try (Connection connection = H2JDBCUtils.getConnection();
             Statement statement = connection.createStatement();) {
            statement.execute(CityQuery.CREATE_TABLE_SQL.toString());
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
    }

    @Override
    public void dropTable() {
        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CityQuery.DROP_TABLE_SQL.toString())) {
            System.out.println(preparedStatement);
            preparedStatement.execute();
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
    }

    @Override
    public void insertRecord(City city) {
        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CityQuery.INSERT_CITY_SQL.toString())) {

            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getRegion());
            preparedStatement.setString(3, city.getDistrict());
            preparedStatement.setInt(4, city.getPopulation());
            preparedStatement.setInt(5, city.getFoundation());

            // TODO 3 - Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }

    }

    @Override
    public void updateRecord(int id, City newCity) {
        System.out.println(CityQuery.UPDATE_USERS_SQL);

        // TODO 1 - Establishing Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // TODO 2 - Create Statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(CityQuery.UPDATE_USERS_SQL.toString())) {

            preparedStatement.setString(1, newCity.getName());
            preparedStatement.setString(2, newCity.getRegion());
            preparedStatement.setString(3, newCity.getDistrict());
            preparedStatement.setInt(4, newCity.getPopulation());
            preparedStatement.setInt(5, newCity.getFoundation());
            preparedStatement.setInt(6, id);

            // TODO 3 - Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
    }

    @Override
    public void selectRecord() {
        try (Connection connection = H2JDBCUtils.getConnection();
             // TODO 2 - Create Statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(CityQuery.SELECT_QUERY_SQL.toString())) {
            System.out.println(preparedStatement);

            // TODO 3 - Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // TODO 4 - Process the ResultSet object
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String region = rs.getString("region");
                String district = rs.getString("district");
                int population = rs.getInt("population");
                int foundation = rs.getInt("foundation");
                System.out.printf("%5d | %26s | %25s | %20s | %10d | %5d\n", id, name, region, district, population, foundation);
            }
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
    }

    @Override
    public void deleteRecord(int id) {
        System.out.println(CityQuery.DELETE_ROW_CITY + "" + id);

        // TODO 1 - Establishing Connection
        try (Connection connection = H2JDBCUtils.getConnection();

             // TODO 2 - Create Statement using connection object
             Statement statement = connection.createStatement()) {

            // TODO 3 - Execute the query or update query
            statement.execute(CityQuery.DELETE_ROW_CITY + "" + id);

        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
    }
}

package DAO.mySqlDao;

import DAO.Tour;
import DAO.TourDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlTourDao implements TourDao {

    String columns = "id, price, name, type, description, discount, count";

    public Tour read(int id) {
        String sql = "SELECT "+columns+" FROM tour WHERE id=?;";
        try(Connection connection = MySqlDaoFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return parseResultSet(resultSet);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Tour> readAllWhere(String where) {
        List<Tour> list = new ArrayList<>();
        try(Connection connection = MySqlDaoFactory.getConnection()) {
            String sql = "SELECT "+columns+" FROM tour;";
            PreparedStatement statement = connection.prepareStatement(sql);

//            statement.setString(1, where);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                list.add(parseResultSet(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Tour parseResultSet(ResultSet rs) throws SQLException {
        Tour tour = new Tour();
        tour.setId(rs.getInt("id"));
        tour.setName(rs.getString("name"));
        tour.setType(rs.getString("type"));
        tour.setDescription(rs.getString("description"));
        tour.setDiscount(rs.getInt("discount"));
        tour.setCount(rs.getInt("count"));
        tour.setPrice(rs.getInt("price"));
        return tour;
    }
}

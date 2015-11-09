package DAO.mySqlDao;

import DAO.Tour;
import DAO.TourDao;

import java.sql.*;

public class MySqlTourDao implements TourDao {

    String columns = "id, price, name, type, description, discount, count";

    public Tour read(int id) {
        try(Connection connection = MySqlDaoFactory.getConnection()) {
            String sql = "SELECT "+columns+" FROM tour WHERE id=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) return createTour(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Tour createTour(ResultSet rs) throws SQLException {
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

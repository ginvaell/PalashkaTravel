package DAO.mySql;

import DAO.HotelDao;
import DAO.beans.Hotel;
import DAO.criterias.HotelCriteria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySqlHotelDao extends MySqlAbstractReadDao<Hotel> implements HotelDao {
    private final String table = "hotel";
    private final String baseColumns = "main.id, main.name, main.stars, main.stars, city.city, city.id";


    @Override
    protected String getColumns() {
        return baseColumns;
    }

    @Override
    protected String getTable() {
        return "city, "+table;
    }

    @Override
    protected String getAdditional() {
        return " AND main.city = city.id ";
    }

    @Override
    protected Hotel parseResultSet(ResultSet resultSet) throws SQLException {
        Hotel Hotel = new Hotel();
        Hotel.setId(resultSet.getInt("main.id"));
        Hotel.setCityId(resultSet.getInt("city.id"));
        Hotel.setName(resultSet.getString("main.name"));
//        Hotel.setDescription(resultSet.getString("main.description"));
        Hotel.setCity(resultSet.getString("city.city"));
        return Hotel;
    }

}

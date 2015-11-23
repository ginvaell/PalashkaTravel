package DAO.mySql;

import DAO.CityDao;
import DAO.beans.City;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DAO.mySql.Utils.*;

public class MySqlCityDao extends MySqlAbstractDao<City> implements CityDao {
    private  final String table = "city";
    private final String baseColumns = "main.id, main.city, main.country";

    @Override
    protected String getColumns() {
        return baseColumns;
    }

    @Override
    protected String getTable() {
        return table;
    }

    @Override
    protected City parseResultSet(ResultSet resultSet) throws SQLException {
        City city = new City();
        city.setId(resultSet.getInt("main.id"));
        city.setCity(resultSet.getString("main.city"));
        city.setCountry(resultSet.getString("main.country"));
        return city;
    }

    @Override
    protected String parseBeenForUpdate(City been) {
        return "city="+toQuote(been.getCity())+" ,"+
               "country="+ toQuote(been.getCountry());
    }

    @Override
    protected String parseBeen(City been) {
        return toQuote(been.getCity())+" ,"+
                toQuote(been.getCountry());
    }

    @Override
    public String getAllColumns() {
        return baseColumns;
    }
}

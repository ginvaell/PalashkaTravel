package DAO.mySql;

import DAO.CityDao;
import DAO.beans.City;
import DAO.criterias.CityCriteria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySqlCityDao extends MySqlAbstractReadDao<City> implements CityDao {
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


}

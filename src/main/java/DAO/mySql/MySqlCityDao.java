package DAO.mySql;

import DAO.CityDao;
import DAO.TypeDao;
import DAO.beans.City;
import DAO.beans.Type;
import DAO.criterias.CityCriteria;
import DAO.criterias.TypeCriteria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySqlCityDao extends MySqlAbstractReadDao implements CityDao {
    private static final String table = "city";
    private static final String baseColumns = table+".id, "+table+".city, "+table+".country ";
    private CityCriteria criteria;

    public void setCriteria(CityCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public City read(int id) {
        criteria = new CityCriteria();
        criteria.setId(String.valueOf(id));
        List<City> list = readAll();
        criteria = null;
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    protected Object parseResultSet(ResultSet resultSet) throws SQLException {
        City city = new City();
        city.setId(resultSet.getInt("id"));
        city.setCity(resultSet.getString("city"));
        city.setCountry(resultSet.getString("country"));
        return city;
    }

    @Override
    protected String readAllQuery() {
        return parseCriteria();
    }

    private String parseCriteria() {
        String sql = "SELECT " + baseColumns + " FROM " + table + " WHERE 1=1";
        if (criteria != null) {
            String tmp;
            if ((tmp = criteria.getId()) != null) sql += " AND id=" + tmp;
            if ((tmp = criteria.getCity()) != null) sql += " AND city=" + toQuote(tmp);
            if ((tmp = criteria.getCountry()) != null) sql += " AND country=" + toQuote(tmp);
        }
        sql += ";";
        return sql;
    }

}

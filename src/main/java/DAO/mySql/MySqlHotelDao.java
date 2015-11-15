package DAO.mySql;

import DAO.HotelDao;
import DAO.beans.Hotel;

import java.sql.ResultSet;
import java.sql.SQLException;

import static DAO.mySql.Utils.toQuote;

public class MySqlHotelDao extends MySqlAbstractDao<Hotel> implements HotelDao {
    private final String table = "hotel";
    private final String baseColumns = "main.id, main.stars, main.city, main.name";
    private final String foreignColumns = ", city.city";
    private final String listColumns = baseColumns + foreignColumns;


    @Override
    protected String getColumns() {
        return listColumns;
    }

    @Override
    protected String getTable() {
        return "city, " + table;
    }

    @Override
    protected String getAdditional() {
        return " AND main.city = city.id ";
    }

    @Override
    protected Hotel parseResultSet(ResultSet resultSet) throws SQLException {
        Hotel Hotel = new Hotel();
        Hotel.setId(resultSet.getInt("main.id"));
        Hotel.setCityId(resultSet.getInt("main.city"));
        Hotel.setName(resultSet.getString("main.name"));
//        Hotel.setDescription(resultSet.getString("main.description"));
        Hotel.setCity(resultSet.getString("city.city"));
        return Hotel;
    }

    @Override
    protected String parseBeenForUpdate(Hotel been) {
        return "stars="+been.getStars() + " ," +
               "city="+ been.getCityId() + " ," +
               "name="+ toQuote(been.getName());
    }

    @Override
    protected String parseBeen(Hotel been) {
        return "" + been.getStars() + " ," +
                been.getCityId() + " ," +
                toQuote(been.getName());
    }

    @Override
    protected String getAllColumns() {
        return baseColumns;
    }

}

package DAO.mySql;

import DAO.beans.Tour;
import DAO.TourDao;

import java.sql.*;
import java.text.SimpleDateFormat;

import static DAO.mySql.Utils.toQuote;


public class MySqlTourDao extends MySqlAbstractDao<Tour> implements TourDao {

    private static final String mainTable = "tour";
    private static final String baseColumns = "main.id, main.name, main.type, main.start, main.end, " +
            "main.description, main.discount, main.hotel, main.img, main.price ";
    private String foreignColumns = ", types.name, hotel.name, city.city, city.country";
    private String listColumns = baseColumns + foreignColumns;
    private static final String detail = " ,main.text";

    {
        LIST.setColumns(listColumns);
        DETAILS.setColumns(listColumns + detail);

    }


    @Override
    protected String getColumns() {
        return state.getColumns();
    }

    @Override
    protected String getTable() {
        return "city, hotel, types, " + mainTable;
    }

    @Override
    protected String getAdditional() {
        return " AND main.type = types.id AND main.hotel = hotel.id AND hotel.city = city.id";
    }

    protected Tour parseResultSet(ResultSet rs) throws SQLException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Tour tour = new Tour();
        tour.setId(rs.getInt("main.id"));
        tour.setName(rs.getString("main.name"));
        tour.setHotel(rs.getString("hotel.name"));
        tour.setType(rs.getString("types.name"));
        tour.setCity(rs.getString("city.city"));
        tour.setCountry(rs.getString("city.country"));
        tour.setImg(rs.getString("main.img"));
        tour.setDescription(rs.getString("main.description"));
        tour.setTypeId(rs.getInt("main.type"));
        tour.setHotelId(rs.getInt("main.hotel"));
        tour.setDiscount(rs.getInt("main.discount"));
        tour.setPrice(rs.getInt("main.price"));
        tour.setStart(format.format(rs.getDate("main.start")));
        tour.setEnd(format.format(rs.getDate("main.end")));
        if (state == DETAILS) tour.setText(rs.getString("main.text"));
        return tour;
    }

    @Override
    protected String parseBeenForUpdate(Tour been) {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return "name=" + toQuote(been.getName()) + " ," +
                "type=" + been.getTypeId() + " ," +
                "start=" + toQuote(been.getStart()) + " ," +
                "end=" + toQuote(been.getEnd()) + " ," +
                "discount=" + been.getDiscount() + " ," +
                "hotel=" + been.getHotelId() + " ," +
                "img=" + toQuote(been.getImg()) + " ," +
                "price=" + been.getPrice() + " ," +
                "description=" + toQuote(been.getDescription()) + " ," +
                "text=" + toQuote(been.getText());
    }

    @Override
    protected String parseBeen(Tour been) {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return toQuote(been.getName()) + " ," +
                been.getTypeId() + " ," +
                toQuote(been.getStart()) + " ," +
                toQuote(been.getEnd()) + " ," +
                toQuote(been.getDescription()) + " ," +
                been.getDiscount() + " ," +
                been.getHotelId() + " ," +
                toQuote(been.getImg()) + " ," +
                been.getPrice() + " ," +
                toQuote(been.getText());
    }

    @Override
    protected String getAllColumns() {
        return baseColumns + detail;
    }

}

package DAO.mySql;

import DAO.beans.Tour;
import DAO.TourDao;
import DAO.criterias.TourCriteria;

import java.sql.*;
import java.util.List;


public class MySqlTourDao extends MySqlAbstractReadDao<Tour> implements TourDao {

    private static final String table = "tour";
    private static final String baseColumns = "main.end, main.start, main.id, main.price, main.name, main.discount, main.count";
    private static final String detail = " , main.description ";

    {
        LIST.setColumns(baseColumns);
        DETAILS.setColumns(baseColumns + detail);
    }


    @Override
    protected String getColumns() {
        return state.getColumns();
    }

    @Override
    protected String getTable() {
        return table;
    }

    protected Tour parseResultSet(ResultSet rs) throws SQLException {
        Tour tour = new Tour();
        tour.setId(rs.getInt("main.id"));
        tour.setName(rs.getString("main.name"));
//        tour.setType(rs.getString("С.type"));
        tour.setDiscount(rs.getInt("main.discount"));
        tour.setCount(rs.getInt("main.count"));
        tour.setPrice(rs.getInt("main.price"));
        tour.setStart(rs.getDate("main.start"));
        tour.setEnd(rs.getDate("main.end"));
        if (state == DETAILS) tour.setDescription(rs.getString("main.description"));
        return tour;
    }

}

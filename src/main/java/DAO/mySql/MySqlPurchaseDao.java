package DAO.mySql;

import DAO.PurchaseDao;
import DAO.beans.Purchase;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MySqlPurchaseDao extends MySqlAbstractReadDao<Purchase> implements PurchaseDao {

    private static final String table = "purchase";
    private static final String baseColumns = "main.id, main.count, main.price, main.user, main.tour, tour.id, tour.name";

    @Override
    protected String getColumns() {
        return baseColumns;
    }

    @Override
    protected String getTable() {
        return "tour, users, "+table;
    }

    @Override
    protected String getAdditional() {
        return " AND main.user = users.id AND main.tour = tour.id";
    }

    protected Purchase parseResultSet(ResultSet rs) throws SQLException {
        Purchase purchase = new Purchase();
        purchase.setId(rs.getInt("main.id"));
        purchase.setCount(rs.getInt("main.count"));
        purchase.setPrice(rs.getInt("main.price"));
        purchase.setUserId(rs.getInt("main.user"));
        purchase.setTourId(rs.getInt("main.tour"));
        purchase.setTour(rs.getString("tour.name"));
        return purchase;
    }

}

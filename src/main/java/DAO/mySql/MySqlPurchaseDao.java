package DAO.mySql;

import DAO.PurchaseDao;
import DAO.beans.Purchase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import static DAO.mySql.Utils.toQuote;


public class MySqlPurchaseDao extends MySqlAbstractDao<Purchase> implements PurchaseDao {

    private static final String table = "purchase";
    private static final String baseColumns = "main.id, main.user, main.tour, main.count, main.price, main.date ";
    private static final String foreignColumns = ", tour.id, tour.name";
    private static final String listColumns = baseColumns+foreignColumns;

    @Override
    protected String getColumns() {
        return listColumns;
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
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Purchase purchase = new Purchase();
        purchase.setId(rs.getInt("main.id"));
        purchase.setCount(rs.getInt("main.count"));
        purchase.setPrice(rs.getInt("main.price"));
        purchase.setUserId(rs.getInt("main.user"));
        purchase.setTourId(rs.getInt("main.tour"));
        purchase.setTour(rs.getString("tour.name"));
        purchase.setDate(format.format(rs.getDate("main.date")));
        return purchase;
    }

    @Override
    protected String parseBeenForUpdate(Purchase been) {

        return "user="+been.getUserId()+" ,"+
                "tour="+been.getTourId()+" ,"+
                "count="+been.getCount()+" ,"+
                "date="+toQuote(been.getDate())+" ,"+
                "price="+been.getPrice();
    }

    @Override
    protected String parseBeen(Purchase been) {
        return ""+been.getUserId()+" ,"+
                been.getTourId()+" ,"+
                been.getCount()+" ,"+
                been.getPrice()+" ,"+
                toQuote(been.getDate());
    }

    @Override
    protected String getAllColumns() {
        return baseColumns;
    }

}

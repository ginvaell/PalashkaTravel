package DAO.mySqlDao;

import DAO.beans.Tour;
import DAO.TourDao;
import DAO.criterias.TourCriteria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static DAO.mySqlDao.MySqlTourDao.State.DETAILS;
import static DAO.mySqlDao.MySqlTourDao.State.LIST;

public class MySqlTourDao implements TourDao {

    private static final String baseColumns = "tour.end, tour.start, tour.id, tour.price, tour.name, tour.discount, tour.count";
    private static final String  detail = ", tour.description ";
    private static final String table = "tour";
    private State state = LIST;

    public Tour read(int id) {
        TourCriteria criteria = new TourCriteria();
        criteria.setId(String.valueOf(id));
        state = DETAILS;
        List<Tour> list = readAllWhere(criteria);
        state = LIST;
        if (list.isEmpty()) return null;
        else return list.get(0);
//        String sql = "SELECT " + columns + ", tour.description " + " FROM " + table + " WHERE id=?;";
//        try (Connection connection = MySqlDaoFactory.getConnection()) {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, id);
//
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                return parseResultSet(resultSet, 1);
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
    }

    @Override
    public List<Tour> readAllWhere(TourCriteria criteria) {
        List<Tour> list = new ArrayList<>();
        String sql;
        System.out.println(sql = parseCriteria(criteria));
        try (Connection connection = MySqlDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                list.add(parseResultSet(resultSet, 0));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Tour parseResultSet(ResultSet rs, int type) throws SQLException {
        Tour tour = new Tour();
        tour.setId(rs.getInt("tour.id"));
        tour.setName(rs.getString("tour.name"));
//        tour.setType(rs.getString("tour.type"));
        tour.setDiscount(rs.getInt("tour.discount"));
        tour.setCount(rs.getInt("tour.count"));
        tour.setPrice(rs.getInt("tour.price"));
        tour.setStart(rs.getDate("tour.start"));
        tour.setEnd(rs.getDate("tour.end"));
        if (type > 0) tour.setDescription(rs.getString("tour.description"));
        return tour;
    }

    private String parseCriteria(TourCriteria criteria) {
        String sql = "SELECT " + state.getColumns() + " FROM " + table + " WHERE 1=1";
        if (criteria != null) {
            String tmp;
            if ((tmp = criteria.getId()) != null) sql += " AND id=" + tmp;
            if ((tmp = criteria.getName()) != null) sql += " AND name=" + toQuote(tmp);
//            if ((tmp = criteria.getType()) != null) sql += " AND type=" + tmp;
            if ((tmp = criteria.getStart()) != null) sql += " AND start=" + toQuote(tmp);
            if ((tmp = criteria.getStartOver()) != null) sql += " AND start>" + toQuote(tmp);
            if ((tmp = criteria.getStartUnder()) != null) sql += " AND start<" + toQuote(tmp);
            if ((tmp = criteria.getEnd()) != null) sql += " AND end=" + toQuote(tmp);
            if ((tmp = criteria.getEndOver()) != null) sql += " AND end>" + toQuote(tmp);
            if ((tmp = criteria.getEndUnder()) != null) sql += " AND end<" + toQuote(tmp);
            if ((tmp = criteria.getPriceOver()) != null) sql += " AND price >" + tmp;
            if ((tmp = criteria.getPriceUnder()) != null) sql += " AND price <" + tmp;
            if ((tmp = criteria.getCountOver()) != null) sql += " AND count >" + tmp;
            if ((tmp = criteria.getCountUnder()) != null) sql += " AND count <" + tmp;
            if ((tmp = criteria.getDiscountOver()) != null) sql += " AND discount >" + tmp;
            if ((tmp = criteria.getDiscountUnder()) != null) sql += " AND discount <" + tmp;
        }
        sql += ";";
        return sql;
    }

    private String toQuote(String str) {
        return "'"+str+"'";
    }

    enum State {
        LIST(baseColumns),
        DETAILS(baseColumns + detail);
        private String columns;

        State(String columns) {
            this.columns = columns;
        }

        public String getColumns() {
            return columns;
        }
    }
}

package DAO.mySql;

import DAO.Criteria;
import DAO.criterias.BaseCriteria;
import DAO.mySql.criterias.MySqlBaseCriteria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class MySqlAbstractReadDao<T> {
    protected State LIST = new State();
    protected State DETAILS = new State();
    protected State state = LIST;

    public T read(int id) {
        BaseCriteria criteria = new MySqlBaseCriteria();
        criteria.setId(String.valueOf(id));
        state = DETAILS;
        List<T> list = readAll(criteria);
        state = LIST;
        if (list.isEmpty()) return null;
        else return list.get(0);
    }

    public List<T> readAll(Criteria criteria) {
        List<T> list = new ArrayList<>();
        String sql = getSelectQuery() + (criteria!=null?criteria.parse():"");
        System.out.println(sql);
        try (Connection connection = MySqlDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                list.add(parseResultSet(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    protected abstract String getColumns();

    String getSelectQuery() {
        return "SELECT DISTINCT " + getColumns() + " FROM " + getTable() + " AS main WHERE 1=1 "+getAdditional();
    }

    protected abstract String getTable();

    protected String getAdditional() {return "";}

    protected abstract T parseResultSet(ResultSet resultSet) throws SQLException;

    protected String toQuote(String str) {
        return "'"+str+"'";
    }

    public static class State {
        String columns;

        public State() {
        }

        public String getColumns() {
            return columns;
        }

        public void setColumns(String columns) {
            this.columns = columns;
        }
    }

}

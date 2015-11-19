package DAO.mySql;

import DAO.Criteria;
import DAO.beans.City;
import DAO.criterias.BaseCriteria;
import DAO.mySql.criterias.MySqlBaseCriteria;
import com.sun.istack.internal.NotNull;

import static DAO.mySql.Utils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class MySqlAbstractDao<T> {
    protected State LIST = new State();
    protected State DETAILS = new State();
    protected State state = LIST;

    public T readById(int id) {
        BaseCriteria criteria = new MySqlBaseCriteria();
        criteria.setId(String.valueOf(id));
        state = DETAILS;
        List<T> list = read(criteria);
        state = LIST;
        if (list.isEmpty()) return null;
        else return list.get(0);
    }

    public List<T> read(Criteria criteria) {
        List<T> list = new ArrayList<>();
        String sql = getSelectQuery(criteria);
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

    public boolean write(T been) {
        if (been == null) return false;
        String sql = getInsertQuery(been);
        try (Connection connection = MySqlDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            System.out.println(sql);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean delete(Criteria criteria) {
        if (criteria == null) return false;
        String sql = getDeleteQuery(criteria);
        try (Connection connection = MySqlDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            System.out.println(sql);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean deleteById(int id) {
        BaseCriteria criteria = new MySqlBaseCriteria();
        criteria.setId(String.valueOf(id));
        return delete(criteria);
    }

    public boolean update(T been, Criteria criteria) {
        if (been == null || criteria == null) return false;
        String sql = getUpdateQuery(been, criteria);
        try (Connection connection = MySqlDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            System.out.println(sql);
            return statement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateById(T been, int id) {
        BaseCriteria criteria = new MySqlBaseCriteria();
        criteria.setId(String.valueOf(id));
        return update(been, criteria);
    }

    private String getUpdateQuery(T been, Criteria criteria) {
        int index = getTable().lastIndexOf(',')+1;
        if (index < 0) index = 0;
        return "UPDATE "+getTable().substring(index).trim()+"" +
                " SET "+parseBeenForUpdate(been)+
                " WHERE 1=1 "+(criteria!=null?criteria.parse().replaceAll("main.",""):"");
    }

    protected abstract String parseBeenForUpdate(T been);

    protected abstract String parseBeen(T been);

    protected abstract String getColumns();

    String getSelectQuery(Criteria criteria) {
        return "SELECT DISTINCT " + getColumns() + " FROM " + getTable() +
                " AS main WHERE 1=1 "+getAdditional()+ (criteria!=null?criteria.parse():"");
    }

    String getInsertQuery(T been) {
        int index = getTable().lastIndexOf(',')+1;
        if (index < 0) index = 0;
        return "INSERT INTO "+getTable().substring(index) +
                " ("+getInsertColumns()+") VALUES ("+parseBeen(been)+")";
    }

    String getDeleteQuery(Criteria criteria) {
//        int index = getTable().lastIndexOf(',')+1;
//        if (index < 0) index = 0;
        return "DELETE main FROM "+getTable() + " AS main WHERE 1=1 "+getAdditional()+(criteria!=null?criteria.parse():"");
    }

    protected abstract String getTable();

    protected String getAdditional() {return "";}

    protected abstract T parseResultSet(ResultSet resultSet) throws SQLException;

    protected String handleGetAll(String columns) {
        return columns.replaceAll("main.", "").replaceFirst("id, ","");
    }

    protected String getInsertColumns() {
        return handleGetAll(getAllColumns());
    }

    protected abstract String getAllColumns();


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

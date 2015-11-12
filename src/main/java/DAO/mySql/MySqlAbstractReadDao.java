package DAO.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class MySqlAbstractReadDao<T> {
    public List<T> readAll() {
        List<T> list = new ArrayList<>();
        String sql = readAllQuery();
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

    protected abstract T parseResultSet(ResultSet resultSet) throws SQLException;

    protected abstract String readAllQuery();

    protected String toQuote(String str) {
        return "'"+str+"'";
    }

}

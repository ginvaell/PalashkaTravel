package DAO.mySql;

import DAO.UserDao;
import DAO.beans.User;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MySqlUserDao extends MySqlAbstractReadDao<User> implements UserDao {

    private static final String table = "user";
    private static final String baseColumns = "main.id, main.name, main.discount, main.login, main.password, main.role";

    @Override
    protected String getColumns() {
        return baseColumns;
    }

    @Override
    protected String getTable() {
        return table;
    }

    protected User parseResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("main.id"));
        user.setName(rs.getString("main.name"));
        user.setLogin(rs.getString("main.login"));
        user.setPassword(rs.getString("main.password"));
        user.setRole(rs.getString("main.role"));
        user.setDiscount(rs.getInt("main.discount"));
        return user;
    }

}

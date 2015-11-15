package DAO.mySql;

import DAO.UserDao;
import DAO.beans.User;

import java.sql.ResultSet;
import java.sql.SQLException;

import static DAO.mySql.Utils.toQuote;


public class MySqlUserDao extends MySqlAbstractDao<User> implements UserDao {

    private static final String table = "users";
    private static final String baseColumns = "main.id, main.login, main.name, main.password, main.discount, main.role";

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

    @Override
    protected String parseBeenForUpdate(User been) {
        return "login="+toQuote(been.getLogin()) + " ," +
               "name="+ toQuote(been.getName()) + " ," +
               "password="+ toQuote(been.getPassword()) + " ," +
               "discount="+ been.getDiscount() + " ," +
               "role="+ toQuote(been.getRole());
    }

    @Override
    protected String parseBeen(User been) {
        return toQuote(been.getLogin()) + " ," +
                toQuote(been.getName()) + " ," +
                toQuote(been.getPassword()) + " ," +
                been.getDiscount() + " ," +
                toQuote(been.getRole());


    }

    @Override
    protected String getAllColumns() {
        return baseColumns;
    }


}

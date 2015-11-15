package DAO.mySql;

import DAO.TypeDao;
import DAO.beans.Type;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlTypeDao extends MySqlAbstractDao<Type> implements TypeDao {
    private static final String table = "types";
    private static final String baseColumns = "main.id, main.name";
    private static final String details = "";

    @Override
    protected String getColumns() {
        return baseColumns;
    }

    @Override
    protected String getTable() {
        return table;
    }

    @Override
    protected Type parseResultSet(ResultSet resultSet) throws SQLException {
        Type type = new Type();
        type.setId(resultSet.getInt("main.id"));
        type.setName(resultSet.getString("main.name"));
        return type;
    }

    @Override
    protected String parseBeenForUpdate(Type been) {
        return "";
    }

    @Override
    protected String parseBeen(Type been) {
        return "";
    }

    protected String getAllColumns() {
        return baseColumns;
    }


}

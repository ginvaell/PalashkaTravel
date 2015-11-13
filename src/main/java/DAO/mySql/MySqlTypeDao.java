package DAO.mySql;

import DAO.TypeDao;
import DAO.beans.Type;
import DAO.criterias.TypeCriteria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySqlTypeDao extends MySqlAbstractReadDao<Type> implements TypeDao {
    private static final String table = "types";
    private static final String baseColumns = "main.id, main.name";


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


}

package DAO.mySql;

import DAO.TypeDao;
import DAO.beans.Type;
import DAO.criterias.TypeCriteria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySqlTypeDao extends MySqlAbstractReadDao implements TypeDao {
    private static final String baseColumns = "types.id, types.name";
    private static final String table = "types";
    private TypeCriteria criteria;

    public void setCriteria(TypeCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Type read(int id) {
        criteria = new TypeCriteria();
        criteria.setId(String.valueOf(id));
        List<Type> list = readAll();
        criteria = null;
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    protected Object parseResultSet(ResultSet resultSet) throws SQLException {
        Type type = new Type();
        type.setId(resultSet.getInt("id"));
        type.setName(resultSet.getString("name"));
        return type;
    }

    @Override
    protected String readAllQuery() {
        return parseCriteria();
    }

    private String parseCriteria() {
        String sql = "SELECT " + baseColumns + " FROM " + table + " WHERE 1=1";
        if (criteria != null) {
            String tmp;
            if ((tmp = criteria.getId()) != null) sql += " AND id=" + tmp;
            if ((tmp = criteria.getName()) != null) sql += " AND name=" + toQuote(tmp);
        }
        sql += ";";
        return sql;
    }

}

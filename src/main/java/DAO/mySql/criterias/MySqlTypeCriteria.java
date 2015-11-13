package DAO.mySql.criterias;

import DAO.criterias.TypeCriteria;

import static DAO.mySql.Utils.toQuote;

public class MySqlTypeCriteria extends TypeCriteria {
    @Override
    public String parse() {
        String sql="";
        String tmp;
        if ((tmp = getId()) != null) sql += " AND main.id=" + tmp;
        if ((tmp = getName()) != null) sql += " AND main.name=" + toQuote(tmp);
//        sql += ";";
        return sql;
    }
}

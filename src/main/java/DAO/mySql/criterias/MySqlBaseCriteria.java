package DAO.mySql.criterias;

import DAO.criterias.BaseCriteria;

import static DAO.mySql.Utils.toQuote;


public class MySqlBaseCriteria extends BaseCriteria {
    @Override
    public String parse() {
        String sql = "";

        String tmp;
        if ((tmp = getId()) != null) sql += " AND main.id=" + tmp;

//        sql += ";";
        return sql;
    }
}

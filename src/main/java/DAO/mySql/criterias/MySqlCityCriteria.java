package DAO.mySql.criterias;

import DAO.criterias.CityCriteria;

import static DAO.mySql.Utils.toQuote;


public class MySqlCityCriteria extends CityCriteria {
    @Override
    public String parse() {
        String sql = "";

        String tmp;
        if ((tmp = getId()) != null) sql += " AND main.id=" + tmp;
        if ((tmp = getCity()) != null) sql += " AND main.city=" + toQuote(tmp);
        if ((tmp = getCountry()) != null) sql += " AND main.country=" + toQuote(tmp);

//        sql += ";";
        return sql;
    }
}

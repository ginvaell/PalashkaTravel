package DAO.mySql.criterias;

import DAO.criterias.TourCriteria;
import DAO.criterias.UserCriteria;

import static DAO.mySql.Utils.toQuote;

public class MySqlUserCriteria extends UserCriteria {
    @Override
    public String parse() {
        String sql = "";
        String tmp;
        if ((tmp = getId()) != null) sql += " AND main.id=" + tmp;
        if ((tmp = getName()) != null) sql += " AND main.name=" + toQuote(tmp);
        if ((tmp = getLogin()) != null) sql += " AND main.login=" + toQuote(tmp);
        if ((tmp = getPassword()) != null) sql += " AND main.password=" + toQuote(tmp);
        if ((tmp = getRole()) != null) sql += " AND main.role=" + toQuote(tmp);
        if ((tmp = getDiscountOver()) != null) sql += " AND main.discount >" + tmp;
        if ((tmp = getDiscountUnder()) != null) sql += " AND main.discount <" + tmp;

//        sql += ";";
        return sql;
    }
}

package DAO.mySql.criterias;

import DAO.criterias.HotelCriteria;
import DAO.criterias.PurchaseCriteria;

import static DAO.mySql.Utils.toQuote;

public class MySqlPurchaseCriteria extends PurchaseCriteria {
    @Override
    public String parse() {
        String sql = "";

        String tmp;
        if ((tmp = getId()) != null) sql += " AND main.id=" + tmp;
        if ((tmp = getUserId()) != null) sql += " AND users.id=" + tmp;
        if ((tmp = getTour()) != null) sql += " AND tour.name=" + toQuote(tmp);
        if ((tmp = getTourId()) != null) sql += " AND tour.id=" + tmp;
        if ((tmp = getCountOver()) != null) sql += " AND main.count >" + tmp;
        if ((tmp = getCountUnder()) != null) sql += " AND main.count <" + tmp;
        if ((tmp = getPriceOver()) != null) sql += " AND main.price >" + tmp;
        if ((tmp = getPriceUnder()) != null) sql += " AND main.price <" + tmp;

//        sql += ";";
        return sql;
    }


}

package DAO.mySql.criterias;

import DAO.criterias.TourCriteria;

import static DAO.mySql.Utils.toQuote;

public class MySqlTourCriteria extends TourCriteria {
    @Override
    public String parse() {
        String sql = "";
        String tmp;
        if ((tmp = getId()) != null) sql += " AND main.id=" + tmp;
        if ((tmp = getName()) != null) sql += " AND main.name=" + toQuote(tmp);
//            if ((tmp = getType()) != null) sql += " AND main.type=" + tmp;
        if ((tmp = getStart()) != null) sql += " AND main.start=" + toQuote(tmp);
        if ((tmp = getStartOver()) != null) sql += " AND main.start>" + toQuote(tmp);
        if ((tmp = getStartUnder()) != null) sql += " AND main.start<" + toQuote(tmp);
        if ((tmp = getEnd()) != null) sql += " AND main.end=" + toQuote(tmp);
        if ((tmp = getEndOver()) != null) sql += " AND main.end>" + toQuote(tmp);
        if ((tmp = getEndUnder()) != null) sql += " AND main.end<" + toQuote(tmp);
        if ((tmp = getPriceOver()) != null) sql += " AND main.price >" + tmp;
        if ((tmp = getPriceUnder()) != null) sql += " AND main.price <" + tmp;
        if ((tmp = getCountOver()) != null) sql += " AND main.count >" + tmp;
        if ((tmp = getCountUnder()) != null) sql += " AND main.count <" + tmp;
        if ((tmp = getDiscountOver()) != null) sql += " AND main.discount >" + tmp;
        if ((tmp = getDiscountUnder()) != null) sql += " AND main.discount <" + tmp;

//        sql += ";";
        return sql;
    }
}
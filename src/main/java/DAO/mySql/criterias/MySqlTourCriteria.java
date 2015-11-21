package DAO.mySql.criterias;

import DAO.criterias.TourCriteria;

import static DAO.mySql.Utils.toQuote;

public class MySqlTourCriteria extends TourCriteria {
    @Override
    public String parse() {
        String sql = "";
        String tmp;
        if ((tmp = getId()) != null) sql += " AND main.id=" + tmp;
        if ((tmp = getTypeId()) != null) sql += " AND main.type=" + tmp;
        if ((tmp = getHotelId()) != null) sql += " AND main.hotel=" + tmp;
        if ((tmp = getCityId()) != null) sql += " AND city.id=" + tmp;
        if ((tmp = getName()) != null) sql += " AND main.name=" + toQuote(tmp);
        if ((tmp = getStart()) != null) sql += " AND main.start=" + toQuote(tmp);
        if ((tmp = getType()) != null) sql += " AND types.name=" + toQuote(tmp);
        if ((tmp = getHotel()) != null) sql += " AND hotel.name=" + toQuote(tmp);
        if ((tmp = getStartOver()) != null) sql += " AND main.start>" + toQuote(tmp);
        if ((tmp = getStartUnder()) != null) sql += " AND main.start<" + toQuote(tmp);
        if ((tmp = getEnd()) != null) sql += " AND main.end=" + toQuote(tmp);
        if ((tmp = getCountry()) != null) sql += " AND city.country=" + toQuote(tmp);
        if ((tmp = getEndOver()) != null) sql += " AND main.end>" + toQuote(tmp);
        if ((tmp = getEndUnder()) != null) sql += " AND main.end<" + toQuote(tmp);
        if ((tmp = getPriceOver()) != null) sql += " AND main.price*(1-main.discount/100) >" + tmp;
        if ((tmp = getPriceUnder()) != null) sql += " AND main.price*(1-main.discount/100) <" + tmp;
        if ((tmp = getDiscountOver()) != null) sql += " AND main.discount >" + tmp;
        if ((tmp = getDiscountUnder()) != null) sql += " AND main.discount <" + tmp;

//        sql += ";";
        return sql;
    }
}

package DAO.mySql.criterias;

import DAO.criterias.HotelCriteria;

import static DAO.mySql.Utils.toQuote;

public class MySqlHotelCriteria extends HotelCriteria {
    @Override
    public String parse() {
        String sql = "";

        String tmp;
        if ((tmp = getId()) != null) sql += " AND main.id=" + tmp;
        if ((tmp = getCityId()) != null) sql += " AND main.city=" + tmp;
        if ((tmp = getName()) != null) sql += " AND main.name=" + toQuote(tmp);
        if ((tmp = getCity()) != null) sql += " AND city.city=" + toQuote(tmp);

//        sql += ";";
        return sql;
    }


}

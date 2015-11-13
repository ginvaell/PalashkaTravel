package DAO;

import DAO.beans.Hotel;
import DAO.criterias.HotelCriteria;

import java.util.List;

public interface HotelDao {
    Hotel read(int id);
    List<Hotel> readAll(Criteria criteria);

}

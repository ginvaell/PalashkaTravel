package DAO;

import DAO.beans.Hotel;
import DAO.criterias.HotelCriteria;

import java.util.List;

public interface HotelDao {
    Hotel readById(int id);
    List<Hotel> read(Criteria criteria);
    boolean write(Hotel been);
    boolean delete(Criteria criteria);
    boolean update(Hotel been, Criteria criteria);
    boolean deleteById(int id);
    boolean updateById(Hotel been, int id);
}

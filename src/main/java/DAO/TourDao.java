package DAO;

import DAO.beans.Tour;
import DAO.criterias.TourCriteria;

import java.util.List;

public interface TourDao {
    Tour readById(int id);
    List<Tour> read(Criteria criteria);
    boolean write(Tour been);
    boolean delete(Criteria criteria);
    boolean update(Tour been, Criteria criteria);
    boolean deleteById(int id);
    boolean updateById(Tour been, int id);

}

package DAO;

import DAO.beans.City;
import DAO.beans.Tour;
import DAO.criterias.CityCriteria;
import DAO.criterias.TourCriteria;

import java.util.List;

public interface CityDao {
    City readById(int id);
    List<City> read(Criteria criteria);
    boolean write(City city);
    boolean delete(Criteria criteria);
    boolean update(City been, Criteria criteria);
    boolean deleteById(int id);
    boolean updateById(City been, int id);
}

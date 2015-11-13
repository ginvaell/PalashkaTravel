package DAO;

import DAO.beans.City;
import DAO.beans.Tour;
import DAO.criterias.CityCriteria;
import DAO.criterias.TourCriteria;

import java.util.List;

public interface CityDao {
    City read(int id);
    List<City> readAll(Criteria criteria);
}

package DAO;

import DAO.beans.Tour;
import DAO.criterias.TourCriteria;

import java.util.List;

public interface TourDao {
    Tour read(int id);
    List<Tour> readAll();
    void setCriteria(TourCriteria criteria);
}

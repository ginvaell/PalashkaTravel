package DAO;

import DAO.beans.Tour;
import DAO.beans.Type;
import DAO.criterias.TourCriteria;
import DAO.criterias.TypeCriteria;

import java.util.List;

public interface TypeDao {
    Type readById(int id);
    List<Type> read(Criteria criteria);
}

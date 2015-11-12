package DAO;

import DAO.beans.City;

public interface DaoFactory {
    TourDao getTourDao();
    TypeDao getTypeDao();
    CityDao getCityDao();
}

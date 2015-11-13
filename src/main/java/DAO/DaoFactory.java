package DAO;

import DAO.beans.City;
import DAO.criterias.*;

public interface DaoFactory {
    TourDao getTourDao();

    TypeDao getTypeDao();

    CityDao getCityDao();

    HotelDao getHotelDao();

    UserDao getUserDao();

    BaseCriteria getBaseCriteria();

    CityCriteria getCityCriteria();

    HotelCriteria getHotelCriteria();

    TourCriteria getTourCriteria();

    TypeCriteria getTypeCriteria();

    UserCriteria getUserCriteria();
}

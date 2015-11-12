package DAO;

public interface DaoFactory {
    TourDao getTourDao();
    TypeDao getTypeDao();
}

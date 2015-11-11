package DAO;

import java.util.List;

public interface TourDao {
    Tour read(int id);
    List<Tour>readAllWhere(String where);
}

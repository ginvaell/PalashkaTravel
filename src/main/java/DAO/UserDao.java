package DAO;

import DAO.beans.Tour;
import DAO.beans.User;

import java.util.List;

public interface UserDao {
    User read(int id);
    List<User> readAll(Criteria criteria);
}

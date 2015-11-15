package DAO;

import DAO.beans.Tour;
import DAO.beans.User;
import com.sun.istack.internal.NotNull;

import java.util.List;

public interface UserDao {
    User readById(int id);
    List<User> read(Criteria criteria);
    boolean write(User been);
    boolean delete(Criteria criteria);
    boolean update(User been, Criteria criteria);
    boolean deleteById(int id);
    boolean updateById(User been, int id);
}

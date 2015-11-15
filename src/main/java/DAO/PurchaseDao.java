package DAO;

import DAO.beans.Purchase;
import DAO.beans.User;

import java.util.List;

public interface PurchaseDao {
    Purchase readById(int id);
    List<Purchase> read(Criteria criteria);
    boolean write(Purchase been);
    boolean delete(Criteria criteria);
    boolean update(Purchase been, Criteria criteria);
    boolean deleteById(int id);
    boolean updateById(Purchase been, int id);

}

package DAO;

import DAO.beans.Purchase;
import DAO.beans.User;

import java.util.List;

public interface PurchaseDao {
    Purchase read(int id);
    List<Purchase> readAll(Criteria criteria);
}

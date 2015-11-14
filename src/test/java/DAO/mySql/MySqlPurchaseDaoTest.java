package DAO.mySql;

import DAO.DaoFactory;
import DAO.PurchaseDao;
import DAO.UserDao;
import DAO.beans.Purchase;
import DAO.beans.User;
import DAO.criterias.PurchaseCriteria;
import DAO.criterias.UserCriteria;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MySqlPurchaseDaoTest {
    DaoFactory factory= new MySqlDaoFactory();
    PurchaseDao purchaseDao = factory.getPurchaseDao();


    @Test
    public void testRead() throws Exception {

        Purchase purchase = purchaseDao.read(1);
        assertTrue(purchase != null);
        System.out.println(purchase);

    }

    @Test
    public void testReadAllWhere() throws Exception {
        PurchaseCriteria criteria = factory.getPurchaseCriteria();
        criteria.setId("2");
        checkReadAll(criteria);

        criteria = factory.getPurchaseCriteria();
        criteria.setTour("Супер Париж");
        checkReadAll(criteria);

        criteria = factory.getPurchaseCriteria();
        criteria.setTourId("1");
        checkReadAll(criteria);

        criteria = factory.getPurchaseCriteria();
        criteria.setUserId("1");
        checkReadAll(criteria);

        criteria = factory.getPurchaseCriteria();
        criteria.setCountOver("3");
        checkReadAll(criteria);

    }

    private void checkReadAll(PurchaseCriteria criteria) {
        List<Purchase> list;
        list = purchaseDao.readAll(criteria);
        assertTrue(!list.isEmpty());
        System.out.println(list+"\n");
    }
}
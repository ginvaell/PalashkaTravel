package DAO.mySql;

import DAO.DaoFactory;
import DAO.PurchaseDao;
import DAO.beans.Purchase;
import DAO.criterias.PurchaseCriteria;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MySqlPurchaseDaoTest {
    DaoFactory factory= new MySqlDaoFactory();
    PurchaseDao dao = factory.getPurchaseDao();


    @Test
    public void testRead() throws Exception {

        Purchase purchase = dao.readById(1);
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
        list = dao.read(criteria);
        assertTrue(!list.isEmpty());
        System.out.println(list+"\n");
    }

    @Test
    public void testWriteAndDelete() throws Exception {
        Purchase been = new Purchase() ;
        been.setUserId(1);
        been.setPrice(1);
        been.setTourId(1);
        been.setCount(5);
        assertTrue(dao.write(been));
        PurchaseCriteria criteria = factory.getPurchaseCriteria();
        criteria.setPriceUnder("2");
        assertTrue(dao.delete(criteria));
    }
    @Test
    public void testUpdate() {
        Purchase been = dao.readById(1);
        assertTrue(dao.updateById(been, 1));
    }
}
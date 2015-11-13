package DAO.mySql;

import DAO.DaoFactory;
import DAO.TourDao;
import DAO.UserDao;
import DAO.beans.Tour;
import DAO.beans.User;
import DAO.criterias.TourCriteria;
import DAO.criterias.UserCriteria;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MySqlUserDaoTest {
    DaoFactory factory= new MySqlDaoFactory();
    UserDao userDao = factory.getUserDao();


    @Test
    public void testRead() throws Exception {

        User user = userDao.read(1);
        assertTrue(user != null);
        System.out.println(user);

    }

    @Test
    public void testReadAllWhere() throws Exception {
        UserCriteria criteria = factory.getUserCriteria();
        criteria.setId("2");
        checkReadAll(criteria);

        criteria = factory.getUserCriteria();
        criteria.setName("Наталья");
        checkReadAll(criteria);

        criteria = factory.getUserCriteria();
        criteria.setLogin("ginvaell");
        checkReadAll(criteria);

        criteria = factory.getUserCriteria();
        criteria.setDiscountOver("5");
        checkReadAll(criteria);

    }

    private void checkReadAll(UserCriteria criteria) {
        List<User> list;
        list = userDao.readAll(criteria);
        assertTrue(!list.isEmpty());
        System.out.println(list+"\n");
    }
}
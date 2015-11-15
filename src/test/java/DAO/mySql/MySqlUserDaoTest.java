package DAO.mySql;

import DAO.DaoFactory;
import DAO.UserDao;
import DAO.beans.User;
import DAO.criterias.UserCriteria;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MySqlUserDaoTest {
    DaoFactory factory = new MySqlDaoFactory();
    UserDao dao = factory.getUserDao();


    @Test
    public void testRead() throws Exception {

        User user = dao.readById(1);
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
        list = dao.read(criteria);
        assertTrue(!list.isEmpty());
        System.out.println(list + "\n");
    }

    @Test
    public void testWriteAndDelete() throws Exception {
        User been = new User();
        been.setName("test");
        been.setDiscount(5);
        been.setRole("test");
        been.setLogin("test");
        been.setPassword("test");
        assertTrue(dao.write(been));
        UserCriteria criteria = factory.getUserCriteria();
        criteria.setName("test");
        assertTrue(dao.delete(criteria));
    }

    @Test
    public void testUpdate() {
        User been = dao.readById(1);
        assertTrue(dao.updateById(been, 1));
    }
}
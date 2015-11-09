package DAO;

import DAO.mySqlDao.MySqlDaoFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class MySqlTourDaoTest {

    @Test
    public void testRead() throws Exception {
        DaoFactory factory = new MySqlDaoFactory();
        TourDao tourDao = factory.getTourDao();
        Tour tour = tourDao.read(1);
        assertTrue(tour != null);

    }
}
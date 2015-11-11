package DAO.mySqlDao;

import DAO.DaoFactory;
import DAO.Tour;
import DAO.TourDao;
import DAO.mySqlDao.MySqlDaoFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MySqlTourDaoTest {
    DaoFactory factory= new MySqlDaoFactory();
    TourDao tourDao = factory.getTourDao();
    List<Tour> list;

    @Test
    public void testRead() throws Exception {

        Tour tour = tourDao.read(1);
        assertTrue(tour != null);
        System.out.println(tour);

    }

    @Test
    public void testReadAllWhere() throws Exception {
        list = tourDao.readAllWhere("price > 1");
        assertTrue(!list.isEmpty());
        System.out.println(list);
    }
}
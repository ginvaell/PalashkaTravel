package DAO.mySql;

import DAO.DaoFactory;
import DAO.beans.Tour;
import DAO.TourDao;
import DAO.criterias.TourCriteria;
import DAO.mySql.criterias.MySqlTourCriteria;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MySqlTourDaoTest {
    DaoFactory factory= new MySqlDaoFactory();
    TourDao tourDao = factory.getTourDao();


    @Test
    public void testRead() throws Exception {

        Tour tour = tourDao.read(1);
        assertTrue(tour != null);
        System.out.println(tour);

    }

    @Test
    public void testReadAllWhere() throws Exception {
        TourCriteria criteria = factory.getTourCriteria();
        criteria.setId("2");
        checkReadAll(criteria);

        criteria = factory.getTourCriteria();
        criteria.setName("Супер Париж");
        checkReadAll(criteria);

        criteria = factory.getTourCriteria();
        criteria.setCountOver("5");
        checkReadAll(criteria);

        criteria = factory.getTourCriteria();
        criteria.setDiscountOver("5");
        checkReadAll(criteria);

        criteria = factory.getTourCriteria();
        criteria.setStartOver("2015-11-01");
        checkReadAll(criteria);

    }

    private void checkReadAll(TourCriteria criteria) {
        List<Tour> list;
        list = tourDao.readAll(criteria);
        assertTrue(!list.isEmpty());
        System.out.println(list+"\n");
    }
}
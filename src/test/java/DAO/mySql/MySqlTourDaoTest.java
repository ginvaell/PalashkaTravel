package DAO.mySql;

import DAO.DaoFactory;
import DAO.beans.Tour;
import DAO.TourDao;
import DAO.criterias.TourCriteria;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class MySqlTourDaoTest {
    DaoFactory factory= new MySqlDaoFactory();
    TourDao dao = factory.getTourDao();


    @Test
    public void testRead() throws Exception {

        Tour tour = dao.readById(1);
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
        criteria.setDiscountUnder("5");
        checkReadAll(criteria);

        criteria = factory.getTourCriteria();
        criteria.setStartOver("2015-11-01");
        checkReadAll(criteria);

        criteria = factory.getTourCriteria();
        criteria.setHotel("Hotel1");
        checkReadAll(criteria);

        criteria = factory.getTourCriteria();
        criteria.setType("Отдых");
        checkReadAll(criteria);

    }

    private void checkReadAll(TourCriteria criteria) {
        List<Tour> list;
        list = dao.read(criteria);
        assertTrue(!list.isEmpty());
        System.out.println(list+"\n");
    }

    @Test
    public void testWriteAndDelete() throws Exception {
        Tour been = new Tour();
        been.setName("test");
        been.setTypeId(1);
        been.setStart("2015-11-9");
        been.setEnd("2015-11-20");
        been.setDescription("test");
        been.setDiscount(5);
        been.setHotelId(1);
        been.setImg("img");
        been.setPrice(50000);
        assertTrue(dao.write(been));

        TourCriteria criteria = factory.getTourCriteria();
        criteria.setName("test");
        assertTrue(dao.delete(criteria));
    }

    @Test
    public void testUpdate() {
        Tour been = dao.readById(1);
        assertTrue(dao.updateById(been, 1));
    }
}
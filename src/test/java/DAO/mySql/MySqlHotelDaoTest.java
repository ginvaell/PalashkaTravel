package DAO.mySql;

import DAO.DaoFactory;
import DAO.HotelDao;
import DAO.beans.Hotel;
import DAO.criterias.HotelCriteria;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MySqlHotelDaoTest {

    DaoFactory factory= new MySqlDaoFactory();
    HotelDao dao = factory.getHotelDao();

    @Test
    public void testRead() throws Exception {
        Hotel hotel = dao.readById(1);
        assertTrue(hotel != null);
        System.out.println(hotel);
    }

    @Test
    public void testReadAllQuery() throws Exception {
        HotelCriteria criteria = factory.getHotelCriteria();
        criteria.setName("Hotel1");
        checkReadAll(criteria);
        criteria = factory.getHotelCriteria();
        criteria.setCity("Лондон");
        checkReadAll(criteria);
        criteria = factory.getHotelCriteria();
        criteria.setStarsOver("3");
        checkReadAll(criteria);
        checkReadAll(null);
    }

    private void checkReadAll(HotelCriteria criteria) {
        List<Hotel> list;
        list = dao.read(criteria);
        assertTrue(!list.isEmpty());
        System.out.println(list+"\n");
    }

    @Test
    public void testWriteAndDelete() throws Exception {
        Hotel been = new Hotel() ;
        been.setCityId(1);
        been.setName("test");
        been.setStars(5);
        assertTrue(dao.write(been));
        HotelCriteria criteria = factory.getHotelCriteria();
        criteria.setName("test");
        assertTrue(dao.delete(criteria));
    }

    @Test
    public void testUpdate() {
        Hotel been = dao.readById(1);
        assertTrue(dao.updateById(been, 1));
    }
}
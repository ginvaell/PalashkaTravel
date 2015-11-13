package DAO.mySql;

import DAO.CityDao;
import DAO.DaoFactory;
import DAO.HotelDao;
import DAO.beans.City;
import DAO.beans.Hotel;
import DAO.criterias.CityCriteria;
import DAO.criterias.HotelCriteria;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MySqlHotelDaoTest {

    DaoFactory factory= new MySqlDaoFactory();
    HotelDao typeDao = factory.getHotelDao();

    @Test
    public void testRead() throws Exception {
        Hotel hotel = typeDao.read(1);
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
        list = typeDao.readAll(criteria);
        assertTrue(!list.isEmpty());
        System.out.println(list+"\n");
    }
}
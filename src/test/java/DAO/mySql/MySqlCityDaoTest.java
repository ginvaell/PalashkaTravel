package DAO.mySql;

import DAO.CityDao;
import DAO.DaoFactory;
import DAO.TypeDao;
import DAO.beans.City;
import DAO.beans.Type;
import DAO.criterias.CityCriteria;
import DAO.criterias.TypeCriteria;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MySqlCityDaoTest {

    DaoFactory factory= new MySqlDaoFactory();
    CityDao typeDao = factory.getCityDao();

    @Test
    public void testRead() throws Exception {
        City city = typeDao.read(1);
        assertTrue(city != null);
        System.out.println(city);
    }

    @Test
    public void testReadAllQuery() throws Exception {
        CityCriteria criteria = new CityCriteria();
        criteria.setCity("Лондон");
        checkReadAll(criteria);
        criteria = new CityCriteria();
        criteria.setCountry("Россия");
        checkReadAll(criteria);
        checkReadAll(null);
    }

    private void checkReadAll(CityCriteria criteria) {
        List<City> list;
        typeDao.setCriteria(criteria);
        list = typeDao.readAll();
        assertTrue(!list.isEmpty());
        System.out.println(list+"\n");
    }
}
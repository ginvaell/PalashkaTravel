package DAO.mySql;

import DAO.CityDao;
import DAO.DaoFactory;
import DAO.TypeDao;
import DAO.beans.City;
import DAO.beans.Type;
import DAO.criterias.CityCriteria;
import DAO.criterias.TypeCriteria;
import DAO.mySql.criterias.MySqlCityCriteria;
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
        CityCriteria criteria = factory.getCityCriteria();
        criteria.setCity("Лондон");
        checkReadAll(criteria);
        criteria = factory.getCityCriteria();
        criteria.setCountry("Россия");
        checkReadAll(criteria);
        checkReadAll(null);
    }

    private void checkReadAll(CityCriteria criteria) {
        List<City> list;
        list = typeDao.readAll(criteria);
        assertTrue(!list.isEmpty());
        System.out.println(list+"\n");
    }
}
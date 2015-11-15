package DAO.mySql;

import DAO.CityDao;
import DAO.DaoFactory;
import DAO.beans.City;
import DAO.criterias.BaseCriteria;
import DAO.criterias.CityCriteria;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MySqlCityDaoTest {

    DaoFactory factory= new MySqlDaoFactory();
    CityDao dao = factory.getCityDao();

    @Test
    public void testRead() throws Exception {
        City city = dao.readById(1);
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
        list = dao.read(criteria);
        assertTrue(!list.isEmpty());
        System.out.println(list+"\n");
    }

    @Test
    public void testWriteAndDelete() throws Exception {
        City city = new City();
        city.setCity("test");
        city.setCountry("test");
        assertTrue(dao.write(city));
        CityCriteria criteria = factory.getCityCriteria();
        criteria.setCity("test");
        assertTrue(dao.delete(criteria));
    }

    @Test
    public void testUpdate() {
        City been = dao.readById(1);
        assertTrue(dao.updateById(been, 1));
    }
}
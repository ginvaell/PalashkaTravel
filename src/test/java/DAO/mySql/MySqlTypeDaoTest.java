package DAO.mySql;

import DAO.DaoFactory;
import DAO.TypeDao;
import DAO.beans.Type;
import DAO.criterias.TypeCriteria;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MySqlTypeDaoTest {

    DaoFactory factory= new MySqlDaoFactory();
    TypeDao typeDao = factory.getTypeDao();

    @Test
    public void testRead() throws Exception {
        Type type = typeDao.read(1);
        assertTrue(type != null);
        System.out.println(type);
    }

    @Test
    public void testReadAllQuery() throws Exception {
        TypeCriteria criteria = new TypeCriteria();
        criteria.setName("Отдых");
        checkReadAll(criteria);
        checkReadAll(null);
    }

    private void checkReadAll(TypeCriteria criteria) {
        List<Type> list;
        typeDao.setCriteria(criteria);
        list = typeDao.readAll();
        assertTrue(!list.isEmpty());
        System.out.println(list+"\n");
    }
}
package DAO.mySql;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * Created by ginva_000 on 09.11.2015.
 */
public class MySqlDaoFactoryTest {

    @org.junit.Test
    public void testGetConnection() throws Exception {
        Connection connection = MySqlDaoFactory.getConnection();
        assertTrue(!connection.isClosed());
        connection.close();
    }
}
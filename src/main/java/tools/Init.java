package tools;

import DAO.DaoFactory;
import DAO.mySql.MySqlDaoFactory;

public class Init {
    private static DaoFactory factory;
    public static DaoFactory getDaoFactory() {
        if (factory == null) factory = new MySqlDaoFactory();
        return factory;
    }
}

package DAO.mySql;

import DAO.*;
import DAO.criterias.*;
import DAO.mySql.criterias.*;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

//import com.mysql.fabric.jdbc.FabricMySQLDriver;




public class MySqlDaoFactory implements DaoFactory {
    private static String user = "ginvaell";
    private static String password = "12345";
    private static String url = "jdbc:mysql://localhost:3306/travel_agency";
    private static Driver driver;


    public static Connection getConnection() throws SQLException {
        driver = new FabricMySQLDriver();
        DriverManager.registerDriver(driver);
        return DriverManager.getConnection(url, user, password);
//        InitialContext initContext= null;
//        try {
//            initContext = new InitialContext();
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//        DataSource ds = null;
//        try {
//            ds = (DataSource) initContext.lookup("java:comp/env/jdbc/travel_agency");
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//        Connection conn = ds.getConnection();
//        return conn;
    }

    public TourDao getTourDao() {
        return new MySqlTourDao();
    }

    @Override
    public TypeDao getTypeDao() {
        return new MySqlTypeDao();
    }

    @Override
    public CityDao getCityDao() {
        return new MySqlCityDao();
    }

    @Override
    public HotelDao getHotelDao() {
        return new MySqlHotelDao();
    }

    @Override
    public UserDao getUserDao() {
        return new MySqlUserDao();
    }

    @Override
    public PurchaseDao getPurchaseDao() {
        return new MySqlPurchaseDao();
    }

    @Override
    public BaseCriteria getBaseCriteria() {
        return new MySqlBaseCriteria();
    }

    @Override
    public CityCriteria getCityCriteria() {
        return new MySqlCityCriteria();
    }

    @Override
    public HotelCriteria getHotelCriteria() {
        return new MySqlHotelCriteria();
    }

    @Override
    public TourCriteria getTourCriteria() {
        return new MySqlTourCriteria();
    }

    @Override
    public TypeCriteria getTypeCriteria() {
        return new MySqlTypeCriteria();
    }

    @Override
    public UserCriteria getUserCriteria() {
        return new MySqlUserCriteria();
    }

    @Override
    public PurchaseCriteria getPurchaseCriteria() {
        return new MySqlPurchaseCriteria();
    }
}

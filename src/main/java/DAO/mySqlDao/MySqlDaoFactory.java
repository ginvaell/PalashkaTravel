package DAO.mySqlDao;

import DAO.DaoFactory;
import DAO.TourDao;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDaoFactory implements DaoFactory {
    private static String user = "ginvaell";
    private static String password = "12345";
    private static String url = "jdbc:mysql://localhost:3306/travel_agency";
    private static Driver driver;


    public static Connection getConnection() throws SQLException {
        driver = new FabricMySQLDriver();
        DriverManager.registerDriver(driver);
        return DriverManager.getConnection(url, user, password);
    }

    public TourDao getTourDao() {
        return new MySqlTourDao();
    }
}

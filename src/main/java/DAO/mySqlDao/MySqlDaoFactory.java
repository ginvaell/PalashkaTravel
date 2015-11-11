package DAO.mySqlDao;

import DAO.DaoFactory;
import DAO.TourDao;
//import com.mysql.fabric.jdbc.FabricMySQLDriver;



import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
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
//        driver = new FabricMySQLDriver();
//        DriverManager.registerDriver(driver);
//        return DriverManager.getConnection(url, user, password);
        InitialContext initContext= null;
        try {
            initContext = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        DataSource ds = null;
        try {
            ds = (DataSource) initContext.lookup("java:comp/env/jdbc/travel_agency");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        Connection conn = ds.getConnection();
        return conn;
    }

    public TourDao getTourDao() {
        return new MySqlTourDao();
    }
}

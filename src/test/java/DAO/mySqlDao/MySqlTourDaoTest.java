package DAO.mySqlDao;

import DAO.DaoFactory;
import DAO.beans.Tour;
import DAO.TourDao;
import DAO.criterias.TourCriteria;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.tribes.util.StringManager;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class MySqlTourDaoTest {
    DaoFactory factory= new MySqlDaoFactory();
    TourDao tourDao = factory.getTourDao();
    /** The tomcat instance. */
    private Tomcat mTomcat;
    /** The temporary directory in which Tomcat and the app are deployed. */
    private String mWorkingDir = System.getProperty("java.io.tmpdir");

    @Before
    public void setup() throws Throwable {
//        mTomcat = new Tomcat();
//        mTomcat.setPort(0);
//        mTomcat.setBaseDir(mWorkingDir);
//        mTomcat.getHost().setAppBase(mWorkingDir);
//        mTomcat.getHost().setAutoDeploy(true);
//        mTomcat.getHost().setDeployOnStartup(true);
//        String contextPath = "/" + getApplicationId();
//        File webApp = new File(mWorkingDir, getApplicationId());
//        File oldWebApp = new File(webApp.getAbsolutePath());
//        FileUtils.deleteDirectory(oldWebApp);
//        new ZipExporterImpl(createWebArchive()).exportTo(new File(mWorkingDir + "/" + getApplicationId() + ".war"),
//                true);
//        mTomcat.addWebapp(mTomcat.getHost(), contextPath, webApp.getAbsolutePath());
//        mTomcat.start();

    }

    @Test
    public void testRead() throws Exception {

        Tour tour = tourDao.read(1);
        assertTrue(tour != null);
        System.out.println(tour);

    }

    @Test
    public void testReadAllWhere() throws Exception {
        TourCriteria criteria = new TourCriteria();
        criteria.setId("2");
        checkReadAllWhere(criteria);

        criteria = new TourCriteria();
        criteria.setName("Супер Париж");
        checkReadAllWhere(criteria);

        criteria = new TourCriteria();
        criteria.setCountOver("5");
        checkReadAllWhere(criteria);

        criteria = new TourCriteria();
        criteria.setDiscountOver("5");
        checkReadAllWhere(criteria);

        criteria = new TourCriteria();
        criteria.setStartOver("2015-11-01");
        checkReadAllWhere(criteria);

    }

    private void checkReadAllWhere(TourCriteria criteria) {
        List<Tour> list;
        list = tourDao.readAllWhere(criteria);
        assertTrue(!list.isEmpty());
        System.out.println(list+"\n");
    }
}
package controllers;

import DAO.DaoFactory;
import DAO.beans.Tour;
import DAO.TourDao;
import DAO.criterias.TourCriteria;
import DAO.mySqlDao.MySqlDaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ginva_000 on 11.11.2015.
 */
@WebServlet(name = "TourTest", urlPatterns = "/tourtest")
public class TourTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory factory = new MySqlDaoFactory();
        TourDao tourDao = factory.getTourDao();
        Tour tour = tourDao.read(1);
        TourCriteria criteria = new TourCriteria();
        criteria.setPriceOver("50000");
        System.out.println(tourDao.readAll());
        request.setAttribute("tour", tour);
        request.getRequestDispatcher("/WEB-INF/jsp/tourtest.jsp").forward(request, response);
    }
}

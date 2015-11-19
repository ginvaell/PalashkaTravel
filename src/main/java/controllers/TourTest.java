package controllers;

import DAO.DaoFactory;
import DAO.beans.Tour;
import DAO.TourDao;
import DAO.criterias.TourCriteria;
import DAO.mySql.MySqlDaoFactory;
import tools.Init;

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
        TourDao tourDao = Init.getDaoFactory().getTourDao();
        Tour tour = tourDao.readById(1);
        TourCriteria criteria = Init.getDaoFactory().getTourCriteria();
        criteria.setPriceOver("50000");
        System.out.println(tourDao.read(null));
        request.setAttribute("tour", tour);
        request.getRequestDispatcher("/WEB-INF/jsp/tourtest.jsp").forward(request, response);
    }
}

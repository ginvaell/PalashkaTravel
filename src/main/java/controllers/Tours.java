package controllers;

import DAO.DaoFactory;
import DAO.TourDao;
import DAO.beans.*;
import DAO.mySql.MySqlDaoFactory;
import tools.DaoHelper;
import tools.Init;
import tools.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ginva_000 on 15.11.2015.
 */
@WebServlet(name = "tours", urlPatterns = "/tours")
public class Tours extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        TourDao dao = Init.getDaoFactory().getTourDao();
        User user = DaoHelper.getUserFromRequest(request);

        List<Tour> list = dao.read(DaoHelper.getTourCriteriaFromRequest(request, user));
        Utils.reduceAllPrices(list, user);

        List<Hotel> hotels = Init.getDaoFactory().getHotelDao().read(null);
        List<Type> types = Init.getDaoFactory().getTypeDao().read(null);
        List<City> cities = Init.getDaoFactory().getCityDao().read(null);
        request.setAttribute("tours", list);
        request.setAttribute("hotels", hotels);
        request.setAttribute("types", types);
        request.setAttribute("cities", cities);
        request.getRequestDispatcher("/WEB-INF/jsp/tours.jsp").forward(request, response);

    }
}

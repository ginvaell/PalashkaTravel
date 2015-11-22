package controllers.admin;

import DAO.beans.City;
import DAO.beans.Hotel;
import DAO.beans.Tour;
import DAO.beans.Type;
import tools.DaoHelper;
import tools.Init;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ginva_000 on 15.11.2015.
 */
@WebServlet(name = "add_hotel", urlPatterns = "/admin/add_hotel")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin"}))
public class AddHotel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Hotel hotel = DaoHelper.getHotelFromRequest(request);
        Init.getDaoFactory().getHotelDao().write(hotel);
        response.sendRedirect("/admin/hotels");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<City> cities = Init.getDaoFactory().getCityDao().read(null);
        request.setAttribute("cities", cities);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/add_hotel.jsp").forward(request, response);
    }
}

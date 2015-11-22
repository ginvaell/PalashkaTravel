package controllers.admin;

import DAO.beans.City;
import DAO.beans.Hotel;
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

@WebServlet(name = "edit_hotel", urlPatterns = "/admin/edit_hotel")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin"}))
public class EditHotel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Hotel hotel = DaoHelper.getHotelFromRequest(request);
        Init.getDaoFactory().getHotelDao().updateById(hotel, hotel.getId());
        response.sendRedirect("/admin/hotels");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<City> cities = Init.getDaoFactory().getCityDao().read(null);
        int id = Integer.valueOf(request.getParameter("id"));
        Hotel hotel = Init.getDaoFactory().getHotelDao().readById(id);
        request.setAttribute("hotel", hotel);
        request.setAttribute("cities", cities);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/edit_hotel.jsp").forward(request, response);
    }
}

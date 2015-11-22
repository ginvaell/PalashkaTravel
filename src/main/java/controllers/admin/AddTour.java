package controllers.admin;

import DAO.beans.*;
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
@WebServlet(name = "add_tour", urlPatterns = "/admin/add_tour")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin"}))
public class AddTour extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Tour tour = DaoHelper.getTourFromRequest(request);
        Init.getDaoFactory().getTourDao().write(tour);
        response.sendRedirect("/admin/tours");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Hotel> hotels = Init.getDaoFactory().getHotelDao().read(null);
        List<Type> types = Init.getDaoFactory().getTypeDao().read(null);
        request.setAttribute("hotels", hotels);
        request.setAttribute("types", types);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/add_tour.jsp").forward(request, response);
    }
}

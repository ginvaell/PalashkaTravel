package controllers.admin;

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

@WebServlet(name = "edit_tour", urlPatterns = "/admin/edit_tour")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin"}))
public class EditTour extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Tour tour = DaoHelper.getTourFromRequest(request);

        Init.getDaoFactory().getTourDao().updateById(tour, tour.getId());
        response.sendRedirect("/admin/tours");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tourIdStr = request.getParameter("id");
        int tourId = Integer.valueOf(tourIdStr);
        Tour tour = Init.getDaoFactory().getTourDao().readById(tourId);
        List<Hotel> hotels = Init.getDaoFactory().getHotelDao().read(null);
        List<Type> types = Init.getDaoFactory().getTypeDao().read(null);
        request.setAttribute("hotels", hotels);
        request.setAttribute("types", types);
        request.setAttribute("tour", tour);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/edit_tour.jsp").forward(request, response);
    }
}

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

@WebServlet(name = "edit_tour_m", urlPatterns = "/admin/edit_tour_m")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"manager", "admin"}))
public class EditTourM extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        int discount = Integer.valueOf(request.getParameter("discount"));
        Tour tour = Init.getDaoFactory().getTourDao().readById(id);
        tour.setDiscount(discount);
        Init.getDaoFactory().getTourDao().updateById(tour, id);
        response.sendRedirect("/admin/tours");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tourIdStr = request.getParameter("id");
        int tourId = Integer.valueOf(tourIdStr);
        Tour tour = Init.getDaoFactory().getTourDao().readById(tourId);
        request.setAttribute("discount", tour.getDiscount());
        request.setAttribute("id", tourId);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/edit_tour_m.jsp").forward(request, response);
    }
}

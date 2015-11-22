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

@WebServlet(name = "delete_tour", urlPatterns = "/admin/delete_tour")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin"}))
public class DeleteTour extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tourIdStr = request.getParameter("id");
        int tourId = Integer.valueOf(tourIdStr);
        Init.getDaoFactory().getTourDao().deleteById(tourId);
        response.sendRedirect("/admin/tours");
    }
}

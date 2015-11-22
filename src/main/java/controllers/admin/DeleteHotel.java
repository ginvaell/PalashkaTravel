package controllers.admin;

import tools.Init;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delete_hotel", urlPatterns = "/admin/delete_hotel")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin"}))
public class DeleteHotel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tourIdStr = request.getParameter("id");
        int hotelId = Integer.valueOf(tourIdStr);
        Init.getDaoFactory().getHotelDao().deleteById(hotelId);
        response.sendRedirect("/admin/hotels");
    }
}

package controllers.admin;

import DAO.beans.Hotel;
import DAO.beans.User;
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

@WebServlet(name = "admin/hotels", urlPatterns = "/admin/hotels")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin"}))
public class Hotels extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       List<Hotel> hotels = Init.getDaoFactory().getHotelDao().read(null);
        request.setAttribute("hotels", hotels);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/hotels.jsp").forward(request, response);
    }
}

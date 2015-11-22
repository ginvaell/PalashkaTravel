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

/**
 * Created by ginva_000 on 15.11.2015.
 */
@WebServlet(name = "add_city", urlPatterns = "/admin/add_city")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin"}))
public class AddCity extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        City city = DaoHelper.getCityFromRequest(request);
        Init.getDaoFactory().getCityDao().write(city);
        response.sendRedirect("/admin/cities");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/admin/add_city.jsp").forward(request, response);
    }
}

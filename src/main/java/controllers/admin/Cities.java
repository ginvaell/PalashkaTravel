package controllers.admin;

import DAO.beans.City;
import DAO.beans.Hotel;
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

@WebServlet(name = "admin/cities", urlPatterns = "/admin/cities")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin"}))
public class Cities extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       List<City> cities = Init.getDaoFactory().getCityDao().read(null);
        request.setAttribute("cities", cities);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/cities.jsp").forward(request, response);
    }
}

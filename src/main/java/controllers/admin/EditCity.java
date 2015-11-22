package controllers.admin;

import DAO.beans.City;
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

/**
 * Created by ginva_000 on 15.11.2015.
 */
@WebServlet(name = "edit_city", urlPatterns = "/admin/edit_city")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin"}))
public class EditCity extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        City city = DaoHelper.getCityFromRequest(request);
        Init.getDaoFactory().getCityDao().updateById(city, city.getId());
        response.sendRedirect("/admin/cities");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        City city = Init.getDaoFactory().getCityDao().readById(id);
        request.setAttribute("city", city);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/edit_city.jsp").forward(request, response);
    }
}

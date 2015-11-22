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

@WebServlet(name = "delete_city", urlPatterns = "/admin/delete_city")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin"}))
public class DeleteCity extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cityIdStr = request.getParameter("id");
        int cityId = Integer.valueOf(cityIdStr);
        Init.getDaoFactory().getCityDao().deleteById(cityId);
        response.sendRedirect("/admin/cities");
    }
}

package controllers.admin;

import DAO.TourDao;
import DAO.beans.Tour;
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

@WebServlet(name = "admin/users", urlPatterns = "/admin/users")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"manager", "admin"}))
public class Users extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       List<User> users = Init.getDaoFactory().getUserDao().read(null);
        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/users.jsp").forward(request, response);
    }
}

package controllers;

import DAO.DaoFactory;
import DAO.UserDao;
import DAO.beans.User;
import DAO.criterias.UserCriteria;
import DAO.mySql.MySqlDaoFactory;
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
@WebServlet(name = "user_edit", urlPatterns = "/user_edit")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"client", "manager", "admin"}))
public class UserEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        User user = DaoHelper.getUserFromRequest(request);

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        user.setName(name);
        user.setPassword(password);
        Init.getDaoFactory().getUserDao().updateById(user, user.getId());
        response.setCharacterEncoding("UTF-8");
        response.sendRedirect("/profile");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = DaoHelper.getUserFromRequest(request);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/jsp/user_edit.jsp").forward(request, response);
    }
}

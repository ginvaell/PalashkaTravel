package controllers;

import DAO.UserDao;
import DAO.beans.Purchase;
import DAO.beans.Tour;
import DAO.beans.User;
import DAO.criterias.UserCriteria;
import tools.DaoHelper;
import tools.Init;
import tools.StrDate;
import tools.Utils;

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
@WebServlet(name = "buy", urlPatterns = "/buy")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"client", "manager", "admin"}))
public class Buy extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String login = request.getUserPrincipal().getName();
        UserCriteria userCriteria = Init.getDaoFactory().getUserCriteria();
        userCriteria.setLogin(login);
        UserDao userDao = Init.getDaoFactory().getUserDao();
        User user = userDao.read(userCriteria).get(0);

        int count = Integer.valueOf(request.getParameter("count"));
        int price = Integer.valueOf(request.getParameter("price"));
        int tourId = Integer.valueOf(request.getParameter("tourId"));

        Purchase purchase = new Purchase();
        purchase.setDate(StrDate.getCurrentDate());
        purchase.setUserId(user.getId());
        purchase.setCount(count);
        purchase.setPrice(price*count);
        purchase.setTourId(tourId);
        Init.getDaoFactory().getPurchaseDao().write(purchase);
        response.sendRedirect("/profile");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int tourId = Integer.valueOf(request.getParameter("id"));
        Tour tour = Init.getDaoFactory().getTourDao().readById(tourId);
        User user = DaoHelper.getUserFromPrincipal(request);
        Utils.reducePrice(tour, user);
        request.setAttribute("tour", tour);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/jsp/buy.jsp").forward(request, response);
    }
}

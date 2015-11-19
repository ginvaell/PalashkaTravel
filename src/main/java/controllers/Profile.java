package controllers;

import DAO.*;
import DAO.beans.Purchase;
import DAO.beans.Tour;
import DAO.beans.User;
import DAO.criterias.PurchaseCriteria;
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
import java.util.List;

/**
 * Created by ginva_000 on 15.11.2015.
 */

@WebServlet(name = "profile", urlPatterns = "/profile")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"client", "manager", "admin"}))
public class Profile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = DaoHelper.getUserFromRequest(request);
        PurchaseDao dao = Init.getDaoFactory().getPurchaseDao();
        PurchaseCriteria purchaseCriteria = Init.getDaoFactory().getPurchaseCriteria();
        purchaseCriteria.setUserId(""+user.getId());
        List<Purchase> list = dao.read(purchaseCriteria);
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("purchases", list);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(request, response);
    }
}

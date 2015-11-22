package controllers.admin;

import DAO.PurchaseDao;
import DAO.TourDao;
import DAO.beans.Purchase;
import DAO.beans.Tour;
import DAO.beans.User;
import DAO.criterias.PurchaseCriteria;
import tools.Init;
import tools.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "admin/tours", urlPatterns = "/admin/tours")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"manager", "admin"}))
public class Tours extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TourDao dao = Init.getDaoFactory().getTourDao();
        List<Tour> list = dao.read(null);
//        User user = (User)request.getSession().getAttribute("user");
//        Utils.reduceAllPrices(list, user);
        request.setAttribute("tours", list);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/tours.jsp").forward(request, response);
    }
}

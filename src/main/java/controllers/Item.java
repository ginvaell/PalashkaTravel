package controllers;

import DAO.TourDao;
import DAO.beans.Tour;
import DAO.beans.User;
import tools.DaoHelper;
import tools.Init;
import tools.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ginva_000 on 15.11.2015.
 */
@WebServlet(name = "item", urlPatterns = "/item")
public class Item extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        System.out.println(id);
        TourDao dao = Init.getDaoFactory().getTourDao();
        Tour tour = dao.readById(id);
        System.out.println(tour);
        User user = (User)request.getSession().getAttribute("user");
        if (tour != null) {
            Utils.reducePrice(tour, user);
            request.setAttribute("tour", tour);
            request.getRequestDispatcher("/WEB-INF/jsp/item.jsp").forward(request, response);
        }
//        else {
//            request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
//        }
    }
}

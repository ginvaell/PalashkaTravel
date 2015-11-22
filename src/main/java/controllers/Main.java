package controllers;

import DAO.DaoFactory;
import DAO.TourDao;
import DAO.beans.Tour;
import DAO.beans.User;
import DAO.mySql.MySqlDaoFactory;
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
@WebServlet(name = "main", urlPatterns = "/main")
public class Main extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TourDao dao = Init.getDaoFactory().getTourDao();
        List<Tour> list = dao.read(null);
        User user = (User)request.getSession().getAttribute("user");
        Utils.reduceAllPrices(list, user);
        request.setAttribute("tours", list);
        request.getRequestDispatcher("/WEB-INF/jsp/main_page.jsp").forward(request, response);
    }
}

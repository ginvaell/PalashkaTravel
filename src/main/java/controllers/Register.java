package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ginva_000 on 15.11.2015.
 */
@WebServlet(name = "registration", urlPatterns = "/registration")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        DaoFactory factory = new MySqlDaoFactory();
//        TourDao dao = factory.getTourDao();
//        List<Tour> list = dao.read(null);
//        request.setCharacterEncoding("UTF-8");
//        request.setAttribute("tours", list);
        request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp").forward(request, response);
    }
}

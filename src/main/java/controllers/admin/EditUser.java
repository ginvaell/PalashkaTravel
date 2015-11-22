package controllers.admin;

import DAO.beans.User;
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

@WebServlet(name = "edit_user", urlPatterns = "/admin/edit_user")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"manager", "admin"}))
public class EditUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = DaoHelper.getUserFromRequest(request);

        Init.getDaoFactory().getUserDao().updateById(user, user.getId());
        response.sendRedirect("/admin/users");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIdStr = request.getParameter("id");
        int userId = Integer.valueOf(userIdStr);
        User user = Init.getDaoFactory().getUserDao().readById(userId);
        request.setAttribute("editUser", user);

        request.getRequestDispatcher("/WEB-INF/jsp/admin/edit_user.jsp").forward(request, response);
    }
}

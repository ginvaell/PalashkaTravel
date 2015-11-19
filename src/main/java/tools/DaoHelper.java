package tools;

import DAO.UserDao;
import DAO.beans.User;
import DAO.criterias.UserCriteria;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ginva_000 on 19.11.2015.
 */
public class DaoHelper {
    public static User getUserFromRequest(HttpServletRequest request) {
        User user = new User();
        try{
            String login = request.getUserPrincipal().getName();
            UserCriteria userCriteria = Init.getDaoFactory().getUserCriteria();
            userCriteria.setLogin(login);
            UserDao userDao = Init.getDaoFactory().getUserDao();
            user = userDao.read(userCriteria).get(0);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}

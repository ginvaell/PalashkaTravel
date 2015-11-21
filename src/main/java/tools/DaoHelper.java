package tools;

import DAO.UserDao;
import DAO.beans.User;
import DAO.criterias.TourCriteria;
import DAO.criterias.UserCriteria;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ginva_000 on 19.11.2015.
 */
public class DaoHelper {
    public static User getUserFromRequest(HttpServletRequest request) {
        User user = new User();
        try{
            String login = null;
            if(request.getUserPrincipal() != null) {
                login = request.getUserPrincipal().getName();
                UserCriteria userCriteria = Init.getDaoFactory().getUserCriteria();
                userCriteria.setLogin(login);
                UserDao userDao = Init.getDaoFactory().getUserDao();
                user = userDao.read(userCriteria).get(0);
            }
        }
        catch (NullPointerException n) {
            System.out.printf("User is not logged in!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static TourCriteria getTourCriteriaFromRequest(HttpServletRequest request, User user) {
        TourCriteria criteria = Init.getDaoFactory().getTourCriteria();
        String tmp;
        if ((tmp = request.getParameter("name")) != null && !tmp.equals("")) criteria.setName(tmp);
        if ((tmp = request.getParameter("type")) != null && !tmp.equals( "-1")) criteria.setTypeId(tmp);
        if ((tmp = request.getParameter("city")) != null && !tmp.equals( "-1")) criteria.setCityId(tmp);
        if ((tmp = request.getParameter("priceOver")) != null && !tmp.equals("")) criteria.setPriceOver(Utils.raisePrice(tmp, user));
        if ((tmp = request.getParameter("priceUnder")) != null && !tmp.equals("")) criteria.setPriceUnder(Utils.raisePrice(tmp, user));
        if ((tmp = request.getParameter("dateOver")) != null && !tmp.equals("")) criteria.setStartOver(tmp);
        if ((tmp = request.getParameter("dateUnder")) != null && !tmp.equals("")) criteria.setEndUnder(tmp);
        if ((tmp = request.getParameter("hotel")) != null && !tmp.equals("-1")) criteria.setHotelId(tmp);
        return criteria;
    }
}

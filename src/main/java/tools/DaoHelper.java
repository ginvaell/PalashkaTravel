package tools;

import DAO.UserDao;
import DAO.beans.City;
import DAO.beans.Hotel;
import DAO.beans.Tour;
import DAO.beans.User;
import DAO.criterias.TourCriteria;
import DAO.criterias.UserCriteria;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ginva_000 on 19.11.2015.
 */
public class DaoHelper {
    public static User getUserFromPrincipal(HttpServletRequest request) {
        User user = new User();
        try {
            String login = null;
            if (request.getUserPrincipal() != null) {
                login = request.getUserPrincipal().getName();
                UserCriteria userCriteria = Init.getDaoFactory().getUserCriteria();
                userCriteria.setLogin(login);
                UserDao userDao = Init.getDaoFactory().getUserDao();
                user = userDao.read(userCriteria).get(0);
            }
        } catch (NullPointerException n) {
            System.out.printf("User is not logged in!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static TourCriteria getTourCriteriaFromRequest(HttpServletRequest request, User user) {
        TourCriteria criteria = Init.getDaoFactory().getTourCriteria();
        String tmp;
        if ((tmp = request.getParameter("name")) != null && !tmp.equals("")) criteria.setName(tmp);
        if ((tmp = request.getParameter("type")) != null && !tmp.equals("-1")) criteria.setTypeId(tmp);
        if ((tmp = request.getParameter("city")) != null && !tmp.equals("-1")) criteria.setCityId(tmp);
        if ((tmp = request.getParameter("priceOver")) != null && !tmp.equals(""))
            criteria.setPriceOver(Utils.raisePrice(tmp, user));
        if ((tmp = request.getParameter("priceUnder")) != null && !tmp.equals(""))
            criteria.setPriceUnder(Utils.raisePrice(tmp, user));
        if ((tmp = request.getParameter("dateOver")) != null && !tmp.equals("")) criteria.setStartOver(tmp);
        if ((tmp = request.getParameter("dateUnder")) != null && !tmp.equals("")) criteria.setEndUnder(tmp);
        if ((tmp = request.getParameter("hotel")) != null && !tmp.equals("-1")) criteria.setHotelId(tmp);
        return criteria;
    }

    public static Tour getTourFromRequest(HttpServletRequest request) {
        Tour tour = new Tour();

        String tmp;
        int id = 0;
        if ((tmp = request.getParameter("id")) != null) id = Integer.valueOf(tmp);
        String name = request.getParameter("name");
        int type = Integer.valueOf(request.getParameter("type"));
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        int hotel = Integer.valueOf(request.getParameter("hotel"));
        String img = request.getParameter("img");
        int price = Integer.valueOf(request.getParameter("price"));
        int discount = Integer.valueOf(request.getParameter("discount"));
        String description = request.getParameter("description");
        String text = request.getParameter("text");

        tour.setId(id);
        tour.setName(name);
        tour.setTypeId(type);
        tour.setHotelId(hotel);
        tour.setStart(start);
        tour.setEnd(end);
        tour.setPrice(price);
        tour.setDiscount(discount);
        tour.setDescription(description);
        tour.setText(text);
        tour.setImg(img);

        return tour;
    }

    public static User getUserFromRequest(HttpServletRequest request) {
        User user = new User();
        String tmp;
        int id = 0;
        if ((tmp = request.getParameter("id")) != null) id = Integer.valueOf(tmp);
        String role = request.getParameter("role");
        String login = request.getParameter("login");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        int discount = Integer.valueOf(request.getParameter("discount"));

        user.setId(id);
        user.setRole(role);
        user.setLogin(login);
        user.setName(name);
        user.setPassword(password);
        user.setDiscount(discount);
        return user;
    }

    public static Hotel getHotelFromRequest(HttpServletRequest request) {
        Hotel hotel = new Hotel();
        String tmp;
        int id = 0;
        if ((tmp = request.getParameter("id")) != null) id = Integer.valueOf(tmp);
        String name = request.getParameter("name");
        int city = Integer.valueOf(request.getParameter("city"));

        hotel.setName(name);
        hotel.setId(id);
        hotel.setCityId(city);
        return hotel;
    }

    public static City getCityFromRequest(HttpServletRequest request) {
        City city = new City();
        String tmp;
        int id = 0;
        if ((tmp = request.getParameter("id")) != null) id = Integer.valueOf(tmp);
        String country = request.getParameter("country");
        String name = request.getParameter("city");

        city.setId(id);
        city.setCity(name);
        city.setCountry(country);
        return city;
    }
}

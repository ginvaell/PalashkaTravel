package tools;

import DAO.beans.Tour;
import DAO.beans.User;
import DAO.criterias.TourCriteria;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class Utils {
    public static void reducePrice(Tour tour, User user) {
        tour.setPrice(Math.round ((float)tour.getPrice()*(1-(float)(user.getDiscount())/100)));
    }

    public static void reduceAllPrices(List<Tour> list, User user) {
        for (Tour tour: list) {
            Utils.reducePrice(tour, user);
        }
    }

    public static String raisePrice(String price, User user) {
        int tmp = Integer.valueOf(price);
        tmp = Math.round ((float)tmp/(1-(float)(user.getDiscount())/100));
        return ""+tmp;
    }

}

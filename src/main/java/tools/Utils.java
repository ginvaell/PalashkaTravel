package tools;

import DAO.beans.Tour;
import DAO.beans.User;

import java.util.List;

public class Utils {
    public static void reducePrice(Tour tour, User user) {
        tour.setPrice(Math.round ((float)tour.getPrice()*(1-(float)(tour.getDiscount()+user.getDiscount())/100)));
    }

    public static void reduceAllPrices(List<Tour> list, User user) {
        for (Tour tour: list) {
            Utils.reducePrice(tour, user);
        }
    }
}

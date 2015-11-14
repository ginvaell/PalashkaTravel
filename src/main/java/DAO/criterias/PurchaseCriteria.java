package DAO.criterias;


import DAO.Criteria;

public abstract class PurchaseCriteria implements Criteria{
    private String id;
    private String userId;
    private String tour;
    private String tourId;
    private String countOver;
    private String countUnder;
    private String priceOver;
    private String priceUnder;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTour() {
        return tour;
    }

    public void setTour(String tour) {
        this.tour = tour;
    }

    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }

    public String getCountOver() {
        return countOver;
    }

    public void setCountOver(String countOver) {
        this.countOver = countOver;
    }

    public String getCountUnder() {
        return countUnder;
    }

    public void setCountUnder(String countUnder) {
        this.countUnder = countUnder;
    }

    public String getPriceOver() {
        return priceOver;
    }

    public void setPriceOver(String priceOver) {
        this.priceOver = priceOver;
    }

    public String getPriceUnder() {
        return priceUnder;
    }

    public void setPriceUnder(String priceUnder) {
        this.priceUnder = priceUnder;
    }
}

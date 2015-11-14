package DAO.criterias;

import DAO.Criteria;

public abstract class TourCriteria implements Criteria{
    private String id;
    private String name;
    private String type;
    private String typeId;
    private String hotel;
    private String hotelId;
    private String start;
    private String end;
    private String startOver;
    private String startUnder;
    private String endOver;
    private String endUnder;
    private String priceOver;
    private String priceUnder;
    private String countOver;
    private String countUnder;
    private String discountOver;
    private String discountUnder;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
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

    public String getDiscountOver() {
        return discountOver;
    }

    public void setDiscountOver(String discountOver) {
        this.discountOver = discountOver;
    }

    public String getDiscountUnder() {
        return discountUnder;
    }

    public void setDiscountUnder(String discountUnder) {
        this.discountUnder = discountUnder;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStartOver() {
        return startOver;
    }

    public void setStartOver(String startOver) {
        this.startOver = startOver;
    }

    public String getStartUnder() {
        return startUnder;
    }

    public void setStartUnder(String startUnder) {
        this.startUnder = startUnder;
    }

    public String getEndOver() {
        return endOver;
    }

    public void setEndOver(String endOver) {
        this.endOver = endOver;
    }

    public String getEndUnder() {
        return endUnder;
    }

    public void setEndUnder(String endUnder) {
        this.endUnder = endUnder;
    }
}

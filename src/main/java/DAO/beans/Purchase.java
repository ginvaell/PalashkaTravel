package DAO.beans;

public class Purchase {
    private int id;
    private int count;
    private int price;
    private int userId;
    private String tour;
    private int tourId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTour() {
        return tour;
    }

    public void setTour(String tour) {
        this.tour = tour;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", count=" + count +
                ", price=" + price +
                ", userId=" + userId +
                ", tour='" + tour + '\'' +
                ", tourId=" + tourId +
                "}\n";
    }
}

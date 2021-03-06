package DAO.beans;

import java.util.Date;

public class Tour {
    private int id;
    private String name;
    private int typeId;
    private String type;
    private String description;
    private String text;
    private int discount;
    private int price;
    private String start;
    private String end;
    private String img;
    private String hotel;
    private int hotelId;
    private String city;
    private String country;


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
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

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeId=" + typeId +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", text='" + text + '\'' +
                ", discount=" + discount +
                ", price=" + price +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", img='" + img + '\'' +
                ", hotel='" + hotel + '\'' +
                ", hotelId=" + hotelId +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                "}\n";
    }

}

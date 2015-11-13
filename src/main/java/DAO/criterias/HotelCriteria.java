package DAO.criterias;


import DAO.Criteria;

public abstract class HotelCriteria implements Criteria{
    private String id;
    private String cityId;
    private String name;
    private String starsOver;
    private String city;

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

    public String getStarsOver() {
        return starsOver;
    }

    public void setStarsOver(String starsOver) {
        this.starsOver = starsOver;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
}

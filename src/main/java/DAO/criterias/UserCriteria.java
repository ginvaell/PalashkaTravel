package DAO.criterias;

import DAO.Criteria;

public abstract class UserCriteria implements Criteria{
    private String id;
    private String name;
    private String login;
    private String password;
    private String role;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
}

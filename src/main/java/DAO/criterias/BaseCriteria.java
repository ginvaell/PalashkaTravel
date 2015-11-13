package DAO.criterias;

import DAO.Criteria;

public abstract class BaseCriteria implements Criteria{
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

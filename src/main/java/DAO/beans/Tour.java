package DAO.beans;

import com.sun.xml.internal.txw2.DatatypeWriter;

import java.util.Date;

public class Tour {
    private int id;
    private String name;
    private int type;
    private String description;
    private int discount;
    private int count;
    private int price;
    private Date start;
    private Date end;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                ", count=" + count +
                ", price=" + price +
                ", start=" + start +
                ", end=" + end +
                "}\n";
    }
//    public enum Type {
//        REST("Отдых"),
//        TOURISM("Экскурсия"),
//        SHOPPING("Шоппинг");
//
//        private final String name;
//        Type(String name) {
//            this.name = name;
//        }
//
//        @Override
//        public String toString() {
//            return name;
//        }
//
//        public String getName() {
//            return name;
//        }
//    }
}

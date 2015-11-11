package DAO;

public class Tour {
    private int id;
    private String name;
    private Type type;
    private String description;
    private int discount;
    private int count;
    private int price;

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
        return type.getName();
    }

    public void setType(String strType) {
        type = Type.valueOf(strType);
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
                "}\n";
    }

    public enum Type {
        REST("Отдых"),
        TOURISM("Экскурсия"),
        SHOPPING("Шоппинг");

        private final String name;
        Type(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

        public String getName() {
            return name;
        }
    }
}

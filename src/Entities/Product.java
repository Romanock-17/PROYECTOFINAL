package Entities;

public class Product {
    public int ID;
    public String name;
    public String description;
    public int amount;
    public double price;
    public Product() {}
    public Product(int ID, String name, String description, int amount, double price) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

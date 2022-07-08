package ru.job4j.ood.lsp.quality;

import java.util.Date;

public class Food {
    String name;
    Date expiryDate;
    Date createDate;
    double price;
    int discount;

    public Food(String name, Date expiryDate, Date createDate, double price, int discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Food{" + "name='" + name + '\''
                + ", expiryDate=" + expiryDate
                + ", createDate=" + createDate
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }
}

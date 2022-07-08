package ru.job4j.ood.lsp.quality;

import java.util.Date;

public class Meat extends Food {
    String type;
    double weight;

    public Meat(String name, Date expiryDate, Date createDate, double price, int discount, String type, double weight) {
        super(name, expiryDate, createDate, price, discount);
        this.type = type;
        this.weight = weight;
    }
}

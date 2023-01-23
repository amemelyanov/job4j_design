package ru.job4j.ood.lsp.quality;

import java.util.Date;

public class Fish extends Food {
    private String type;
    private double weight;

    public Fish(String name, Date expiryDate, Date createDate, double price, int discount,
                String type, double weight) {
        super(name, expiryDate, createDate, price, discount);
        this.type = type;
        this.weight = weight;
    }
}

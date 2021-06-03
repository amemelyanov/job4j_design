package ru.job4j.ood.lsp;

import ru.job4j.collection.list.List;

import java.util.Map;

public class ProductStore {
    Map<Product, Integer> stock;

    public ProductStore(Map<Product, Integer> stock) {
        this.stock = stock;
    }

    public double getPurchase(List<Product> products) {
        double sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        if (sum > 100 && sum < 1000) {
            sum *= 0.95;
        } else if (sum >= 1000) {
            sum *= 0.90;
        }
        return sum;
    }
}

class PhoneStore extends ProductStore {
    public PhoneStore(Map<Product, Integer> stock) {
        super(stock);
    }

    public double getPurchase(List<Product> products) {
        double sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }
}

class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

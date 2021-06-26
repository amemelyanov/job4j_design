package ru.job4j.ood.lsp.quality;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Shop implements Storage {
    private List<Food> listShop;

    public Shop() {
        listShop = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        double levelOfQuality = getLevelOfQuality(food);
        if (levelOfQuality >= 25 && levelOfQuality <= 75) {
            listShop.add(food);
        } else if (levelOfQuality > 75 && levelOfQuality <= 100) {
            food.price = food.price * (100 - food.discount) / 100;
            listShop.add(food);
        }
    }

    @Override
    public boolean accept(Food food) {
        double levelOfQuality = getLevelOfQuality(food);
        return levelOfQuality >= 25 && levelOfQuality <= 100;
    }

    private double getLevelOfQuality(Food food) {
        long totalLifeInDays = (food.expiryDate.getTime() - food.createDate.getTime()) / 1000 / 60 / 60 / 24;
        if (totalLifeInDays < 0) {
            throw new IllegalArgumentException("Check date of food in " + food);
        }
        long daysFromCreate = (new Date().getTime() - food.createDate.getTime()) / 1000 / 60 / 60 / 24;
        return (double) daysFromCreate / totalLifeInDays * 100;
    }

    @Override
    public String toString() {
        return "Shop{" + "listShop=" + listShop + '}';
    }

    @Override
    public List<Food> getStorageList() {
        return listShop;
    }

    @Override
    public void clear() {
        listShop.clear();
    }
}

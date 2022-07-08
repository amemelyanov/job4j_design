package ru.job4j.ood.lsp.quality;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Trash implements Storage {
    private List<Food> listTrash;

    public Trash() {
        listTrash = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        listTrash.add(food);
    }

    @Override
    public boolean accept(Food food) {
        double levelOfQuality = getLevelOfQuality(food);
        return levelOfQuality > 100;
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
        return "Trash{" + "listTrash=" + listTrash + '}';
    }

    @Override
    public List<Food> getStorageList() {
        return listTrash;
    }

    @Override
    public void clear() {
        listTrash.clear();
    }
}

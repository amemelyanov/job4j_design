package ru.job4j.ood.lsp.quality;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
    private List<Food> listShop;

    public Shop() {
        listShop = new ArrayList<>();
    }

    public List<Food> getListShop() {
        return listShop;
    }

    @Override
    public void add(Food food) {
        listShop.add(food);
    }

    @Override
    public String toString() {
        return "Shop{" + "listShop=" + listShop + '}';
    }
}

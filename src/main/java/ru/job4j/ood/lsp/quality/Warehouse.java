package ru.job4j.ood.lsp.quality;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    private List<Food> listWarehouse;

    public Warehouse() {
        listWarehouse = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        listWarehouse.add(food);
    }

    public List<Food> getListWarehouse() {
        return listWarehouse;
    }

    @Override
    public String toString() {
        return "Warehouse{" + "listWarehouse=" + listWarehouse + '}';
    }
}

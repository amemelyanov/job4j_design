package ru.job4j.ood.lsp.quality;

import java.util.ArrayList;
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

    public List<Food> getListTrash() {
        return listTrash;
    }

    @Override
    public String toString() {
        return "Trash{" + "listTrash=" + listTrash + '}';
    }
}

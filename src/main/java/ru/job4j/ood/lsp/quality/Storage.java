package ru.job4j.ood.lsp.quality;


import java.util.List;

public interface Storage {
    void add(Food food);

    boolean accept(Food food);

    List<Food> getStorageList();

    void clear();
}

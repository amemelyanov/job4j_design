package ru.job4j.ood.lsp.quality;

public interface Storage {
    void add(Food food);
    boolean accept(Food food);
}

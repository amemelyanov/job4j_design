package ru.job4j.ood.lsp.parking;

public class Truck implements Car {
    private int size;
    private String name;

    public Truck(int size, String name) {
        this.size = size;
        this.name = name;
    }

    @Override
    public int getSize() {
        return size;
    }
}

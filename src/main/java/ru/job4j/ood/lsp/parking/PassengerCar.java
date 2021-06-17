package ru.job4j.ood.lsp.parking;

public class PassengerCar implements Car {
    private int size = 1;
    private String name;

    public PassengerCar(String name) {
        this.name = name;
    }

    @Override
    public int getSize() {
        return size;
    }
}

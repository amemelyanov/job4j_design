package ru.job4j.ood.lsp.parking;

public interface ParkingPlaces {
    boolean accept(Car car);
    void add(Car car);
    Car[] getCars();
    int getFreePlaces();
}

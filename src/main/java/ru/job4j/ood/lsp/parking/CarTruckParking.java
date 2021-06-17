package ru.job4j.ood.lsp.parking;

public interface CarTruckParking extends Parking {
    int getFreePlacesForType(String type);
}

package ru.job4j.ood.lsp.parking;

public class TruckParkingPlaces implements ParkingPlaces {
    private int freePlaces;
    private int index;
    private Car[] cars;

    public TruckParkingPlaces(int freePlaces) {
        this.freePlaces = freePlaces;
        this.cars = new Car[freePlaces];
    }

    public Car[] getCars() {
        return cars;
    }

    @Override
    public int getFreePlaces() {
        return freePlaces;
    }

    @Override
    public boolean accept(Car car) {
        return car.getSize() > 1 && freePlaces > 0;
    }

    @Override
    public void add(Car car) {
        cars[index] = car;
        index++;
        freePlaces--;
    }
}

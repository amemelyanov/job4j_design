package ru.job4j.ood.lsp.parking;

public class PassengerParkingPlaces implements ParkingPlaces {
    private int freePlaces;
    private int index;
    private Car[] cars;

    public PassengerParkingPlaces(int freePlaces) {
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
        return index + car.getSize() <= cars.length;
    }

    @Override
    public void add(Car car) {
        int start = index;
        int end = index + car.getSize();
        for (int i = start; i < end; i++) {
            cars[i] = car;
            index++;
            freePlaces--;
        }
    }
}

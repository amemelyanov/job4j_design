package ru.job4j.ood.lsp.parking;

public class PassengerAndTruckParking implements CarTruckParking {
    private PassengerParkingPlaces passengerParkingPlaces;
    private TruckParkingPlaces truckParkingPlaces;

    public PassengerAndTruckParking(int truckNumberPlaces, int passengerNumberPlaces) {
        truckParkingPlaces = new TruckParkingPlaces(truckNumberPlaces);
        passengerParkingPlaces = new PassengerParkingPlaces(passengerNumberPlaces);
    }

    @Override
    public boolean park(Car car) {
        if (truckParkingPlaces.accept(car)) {
            truckParkingPlaces.add(car);
            return true;
        } else if (passengerParkingPlaces.accept(car)) {
            passengerParkingPlaces.add(car);
            return true;
        }
        return false;
    }

    @Override
    public int getFreePlaces(String typePlaces) {
        return passengerParkingPlaces.getFreePlaces() + truckParkingPlaces.getFreePlaces();
    }

    @Override
    public int getFreePlacesForType(String typePlaces) {
        if (typePlaces.equalsIgnoreCase("passenger")) {
            return passengerParkingPlaces.getFreePlaces();
        } else if (typePlaces.equalsIgnoreCase("truck")) {
            return truckParkingPlaces.getFreePlaces();
        }
        return -1;
    }
}

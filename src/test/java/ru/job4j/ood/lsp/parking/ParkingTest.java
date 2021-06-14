package ru.job4j.ood.lsp.parking;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class ParkingTest {
    @Test
    public void whenPassengerCarParking() {
        List<ParkingPlaces> places = new ArrayList<>();
        ParkingPlaces truckPlaces = new TruckParkingPlaces(5);
        ParkingPlaces passengersPlaces = new PassengerParkingPlaces(5);
        places.add(truckPlaces);
        places.add(passengersPlaces);
        Parking parking = new PassengerAndTruckParking(places);
        Car passengerCar = new PassengerCar("toyota");
        parking.parkTheCar(passengerCar);
        assertThat(passengersPlaces.getFreePlaces(), is(4));
        assertThat(truckPlaces.getFreePlaces(), is(5));
    }

    @Test
    public void whenTruckParking() {
        List<ParkingPlaces> places = new ArrayList<>();
        ParkingPlaces truckPlaces = new TruckParkingPlaces(5);
        ParkingPlaces passengersPlaces = new PassengerParkingPlaces(5);
        places.add(truckPlaces);
        places.add(passengersPlaces);
        Parking parking = new PassengerAndTruckParking(places);
        Car truck = new Truck(2, "ford");
        parking.parkTheCar(truck);
        assertThat(passengersPlaces.getFreePlaces(), is(5));
        assertThat(truckPlaces.getFreePlaces(), is(4));
    }

    @Test
    public void whenOnlyPassengerCars() {
        List<ParkingPlaces> places = new ArrayList<>();
        ParkingPlaces truckPlaces = new TruckParkingPlaces(1);
        ParkingPlaces passengersPlaces = new PassengerParkingPlaces(1);
        places.add(truckPlaces);
        places.add(passengersPlaces);
        Parking parking = new PassengerAndTruckParking(places);
        Car passengerCar1 = new PassengerCar("toyota");
        Car passengerCar2 = new PassengerCar("nissan");
        parking.parkTheCar(passengerCar1);
        parking.parkTheCar(passengerCar2);
        assertFalse(parking.parkTheCar(passengerCar2));
        assertThat(passengersPlaces.getFreePlaces(), is(0));
        assertThat(truckPlaces.getFreePlaces(), is(1));
    }

    @Test
    public void whenOnlyTrucks() {
        List<ParkingPlaces> places = new ArrayList<>();
        ParkingPlaces truckPlaces = new TruckParkingPlaces(1);
        ParkingPlaces passengersPlaces = new PassengerParkingPlaces(2);
        places.add(truckPlaces);
        places.add(passengersPlaces);
        Parking parking = new PassengerAndTruckParking(places);
        Car truck1 = new Truck(2, "toyota");
        Car truck2 = new Truck(2, "nissan");
        Car truck3 = new Truck(2, "ford");
        parking.parkTheCar(truck1);
        parking.parkTheCar(truck2);
        assertFalse(parking.parkTheCar(truck3));
        assertThat(passengersPlaces.getFreePlaces(), is(0));
        assertThat(truckPlaces.getFreePlaces(), is(0));
    }

    @Test
    public void whenPlacesIsZero() {
        List<ParkingPlaces> places = new ArrayList<>();
        ParkingPlaces truckPlaces = new TruckParkingPlaces(0);
        ParkingPlaces passengersPlaces = new PassengerParkingPlaces(0);
        places.add(truckPlaces);
        places.add(passengersPlaces);
        Parking parking = new PassengerAndTruckParking(places);
        Car passengerCar = new PassengerCar("toyota");
        Car truck = new Truck(2, "nissan");
        assertFalse(parking.parkTheCar(passengerCar));
        assertFalse(parking.parkTheCar(truck));
    }
}

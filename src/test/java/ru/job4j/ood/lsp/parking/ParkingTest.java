package ru.job4j.ood.lsp.parking;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ParkingTest {
    @Test
    public void whenPassengerCarParking() {
        Parking parking = new PassengerAndTruckParking(5, 5);
        Car passengerCar = new PassengerCar("toyota");
        assertTrue(parking.park(passengerCar));
        assertThat(parking.getFreePlacesForType("passenger"), is(4));
        assertThat(parking.getFreePlacesForType("truck"), is(5));
    }

    @Test
    public void whenTruckParking() {
        Parking parking = new PassengerAndTruckParking(5, 5);
        Car truck = new Truck(2, "ford");
        assertTrue(parking.park(truck));
        assertThat(parking.getFreePlacesForType("passenger"), is(5));
        assertThat(parking.getFreePlacesForType("truck"), is(4));
    }

    @Test
    public void whenOnlyPassengerCars() {
        Parking parking = new PassengerAndTruckParking(1, 1);
        Car passengerCar1 = new PassengerCar("toyota");
        Car passengerCar2 = new PassengerCar("nissan");
        assertTrue(parking.park(passengerCar1));
        assertFalse(parking.park(passengerCar2));
        assertThat(parking.getFreePlacesForType("passenger"), is(0));
        assertThat(parking.getFreePlacesForType("truck"), is(1));
    }

    @Test
    public void whenOnlyTrucks() {
        Parking parking = new PassengerAndTruckParking(1, 2);
        Car truck1 = new Truck(2, "toyota");
        Car truck2 = new Truck(2, "nissan");
        Car truck3 = new Truck(2, "ford");
        assertTrue(parking.park(truck1));
        assertTrue(parking.park(truck2));
        assertFalse(parking.park(truck3));
        assertThat(parking.getFreePlacesForType("passenger"), is(0));
        assertThat(parking.getFreePlacesForType("truck"), is(0));
    }

    @Test
    public void whenPlacesIsZero() {
        Parking parking = new PassengerAndTruckParking(0, 0);
        Car passengerCar = new PassengerCar("toyota");
        Car truck = new Truck(2, "nissan");
        assertFalse(parking.park(passengerCar));
        assertFalse(parking.park(truck));
    }
}

package ru.job4j.ood.isp;

public class ElectricCar implements Car {
    @Override
    public void move() {
        System.out.println("Move car...");
    }

    @Override
    public void stop() {
        System.out.println("Stop car...");
    }

    @Override
    public void refuel() {
        throw new UnsupportedOperationException();
    }

    void recharge() {
        System.out.println("Recharge car...");
    }
}

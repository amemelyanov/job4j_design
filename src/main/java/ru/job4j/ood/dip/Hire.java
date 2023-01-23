package ru.job4j.ood.dip;

public class Hire {
    private Car car;

    public Hire(Car car) {
        this.car = car;
    }

    void getHire() {
        System.out.println("Hire a" + car.getModel());
    }
}

class Car {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}
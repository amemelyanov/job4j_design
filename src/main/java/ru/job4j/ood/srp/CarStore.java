package ru.job4j.ood.srp;

import org.json.JSONObject;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarStore {
    private List<Car> cars;
    private int totalCost;

    public void sell(Car car) {
        cars.remove(car);
        totalCost -= car.getPrice();
    }

    public void addToStore(Car car) {
        cars.add(car);
        totalCost += car.getPrice();
    }

    public void printAllCar() {
        System.out.println("==================");
        cars.forEach(System.out::println);
        System.out.println("==================");
    }

    public void totalCost() {
        System.out.println(totalCost);
    }

    public void printAllModel() {
        Set<String> set = new HashSet<>();
        for (Car car : cars) {
            set.add(car.getModel());
        }
        for (String s : set) {
            System.out.println(s);
        }
    }
}

class Car {
    private String model;
    private int price;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{"
                + "model='" + model + System.lineSeparator()
                + ", price=" + price
                + '}';
    }
}
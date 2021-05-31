package ru.job4j.ood.ocp;

import java.util.List;

public class PhoneStore {
    List<Phone> phones;

    public PhoneStore(List<Phone> phones) {
        this.phones = phones;
    }

    public void setPrice() {
        for (Phone phone : phones) {
            if (phone.getName().equals("Samsung")) {
                phone.setPrice(70000);
            } else if (phone.getName().equals("iphone")) {
                phone.setPrice(100000);
            }
        }
    }
}

class Phone {
    private final String name;
    private int price;
    public Phone(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

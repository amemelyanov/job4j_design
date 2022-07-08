package ru.job4j.ood.isp;

public class Pen implements WritingAccessory {
    @Override
    public void write() {
        System.out.println("Write...");
    }

    @Override
    public void paint() {
        System.out.println("Paint...");
    }

    @Override
    public void sharpen() {
        throw new UnsupportedOperationException();
    }

    public void refillInk() {
        System.out.println("Refill ink...");
    }
}

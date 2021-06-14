package ru.job4j.ood.isp;

public class Pencil implements WritingAccessory {
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
        System.out.println("Sharpen...");
    }
}

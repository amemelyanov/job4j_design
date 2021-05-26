package ru.job4j.ood.srp;

import java.util.Scanner;

public class SimpleSum implements Sum {
    private int x;
    private int y;

    @Override
    public void input() {
        System.out.println("Please enter two digits: ");
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        y = in.nextInt();
    }

    public double sum() {
        return x + y;
    }

    public static void main(String[] args) {
        SimpleSum ss = new SimpleSum();
        ss.input();
        System.out.println(ss.sum());
    }
}

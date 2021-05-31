package ru.job4j.ood.ocp;

public class AbstractBeing {
    private static class Bird {
        String name;
        int beakLength;

        public Bird(String name, int beakLength) {
            this.name = name;
            this.beakLength = beakLength;
        }

        public void fly() {
            System.out.println("It flies...");
        }
    }

    private static class Bee extends Bird {

        public Bee(String name, int beakLength) {
            super(name, beakLength);
        }
    }

}

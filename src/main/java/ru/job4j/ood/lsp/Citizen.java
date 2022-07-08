package ru.job4j.ood.lsp;

public class Citizen {
    protected String name;
    protected int age;

    public Citizen(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void vote() {
        if (age < 18) {
            throw new IllegalArgumentException("Invalid age!");
        }
        System.out.println("Vote");
    }
}

class AmericanCitizen extends Citizen {
    int id;

    public AmericanCitizen(String name, int age, int id) {
        super(name, age);
        this.id = id;
    }

    @Override
    public void vote() {
        if (age < 21) {
            throw new IllegalArgumentException("Invalid age!");
        }
        System.out.println("Vote");
    }
}

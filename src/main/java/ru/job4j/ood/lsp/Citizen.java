package ru.job4j.ood.lsp;

public class Citizen {
    private  String name;

    private  int age;

    public Citizen(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
    private int id;

    public AmericanCitizen(String name, int age, int id) {
        super(name, age);
        this.id = id;
    }

    @Override
    public void vote() {
        if (getAge() < 21) {
            throw new IllegalArgumentException("Invalid age!");
        }
        System.out.println("Vote");
    }
}

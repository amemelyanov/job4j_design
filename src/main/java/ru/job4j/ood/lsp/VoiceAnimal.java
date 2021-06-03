package ru.job4j.ood.lsp;

public class VoiceAnimal {
    public void getVoice(Animal animal) {
        if (animal instanceof Cat) {
            System.out.println("Meo meo");
        } else if (animal instanceof Dog) {
            System.out.println("Gav gav");
        }
    }
}

class Animal {

}

class Cat extends Animal {
    String sound = "Meo meo";
}

class Dog extends Animal {
    String sound = "Gav gav";
}

class TestVoiceAnimal {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        VoiceAnimal voiceAnimal = new VoiceAnimal();
        voiceAnimal.getVoice(cat);
        voiceAnimal.getVoice(dog);
    }
}
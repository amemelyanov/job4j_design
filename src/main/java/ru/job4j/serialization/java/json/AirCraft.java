package ru.job4j.serialization.java.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class AirCraft {
    boolean isPassenger;
    int rangeOfFlight;
    String modelName;
    Engine engine;
    String[] subModels;

    public AirCraft(boolean isPassenger, int rangeOfFlight, String modelName, Engine engine, String[] subModels) {
        this.isPassenger = isPassenger;
        this.rangeOfFlight = rangeOfFlight;
        this.modelName = modelName;
        this.engine = engine;
        this.subModels = subModels;
    }

    @Override
    public String toString() {
        return "AirCraft{"
                + "isPassenger=" + isPassenger
                + ", rangeOfFlight=" + rangeOfFlight
                + ", modelName='" + modelName + '\''
                + ", engine=" + engine
                + ", subModels=" + Arrays.toString(subModels)
                + '}';
    }

    public static class Engine {
        String name;
        int horsePower;

        public Engine(String name, int horsePower) {
            this.name = name;
            this.horsePower = horsePower;
        }

        @Override
        public String toString() {
            return "Engine{"
                    + "name='"
                    + name + '\''
                    + ", horsePower=" + horsePower
                    + '}';
        }
    }

    public static void main(String[] args) {
        String[] subModels = {"A318", "A319", "A321"};
        AirCraft airCraft = new AirCraft(true, 6000,
                "A320", new Engine("CFM", 105900), subModels);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String airCraftJSON = gson.toJson(airCraft);
        System.out.println(airCraftJSON);

        AirCraft airCraftFromJSON = gson.fromJson(airCraftJSON, AirCraft.class);
        System.out.println(airCraftFromJSON);
    }
}

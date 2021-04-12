package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() throws IllegalArgumentException {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().filter(str -> str.trim().length() > 0 && !str.startsWith("#"))
                    .forEach(line -> {
                        String[] param = line.trim().split("=");
                        if (param.length < 2 || param[0].isEmpty() || param[1].isEmpty()) {
                            throw new IllegalArgumentException();
                        }
                        values.put(param[0], param[1]);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config config = new Config("./data/pair_with_illegal_argument_value.properties");
        config.load();
    }
}
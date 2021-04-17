package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (String arg : args) {
            if (!arg.contains("=")) {
                continue;
            }
            if (!validate(arg)) {
                throw new IllegalArgumentException();
            }
                values.put(arg.split("=")[0].substring(1), arg.split("=")[1]);
        }
    }

    private boolean validate(String arg) {
        return arg.startsWith("-")
                && arg.split("=").length > 1
                && arg.split("=")[0].substring(1).length() != 0;
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));

        ArgsName jar = ArgsName.of(new String[] {"-jar", "pack.jar", "-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
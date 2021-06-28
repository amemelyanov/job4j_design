package ru.job4j.io.find;

import java.util.HashMap;
import java.util.Map;

public class ArgsNames {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length < 4) {
            throw new IllegalArgumentException("Please check number pairs of keys and parameters."
                    + System.lineSeparator()
                    + "Use: java -jar find.jar -d=DIRECTORY -n=NAME|MASK|REGEX "
                    + "-t=TYPE(NAME|MASK|REGEX) -o=OUT_FILE.");
        }
        for (String arg : args) {
            if (!arg.contains("=")) {
                continue;
            }
            String[] argArr = arg.split("=");
            if (!validate(argArr)) {
                throw new IllegalArgumentException("Please check key name or content of parameter."
                        + System.lineSeparator()
                        + "Use: java -jar find.jar -d=DIRECTORY -n=NAME|MASK|REGEX "
                        + "-t=TYPE(NAME|MASK|REGEX) -o=OUT_FILE.");
            }
            values.put(argArr[0].substring(1), argArr[1]);
        }
    }

    private boolean validate(String[] argArr) {
        boolean rsl = (argArr[0].equals("-d") || argArr[0].equals("-n")
                || argArr[0].equals("-t") || argArr[0].equals("-o")) || argArr.length > 1;
        if (argArr[0].equals("-t") && !(argArr[1].equals("regex")
                || argArr[1].equals("mask") || argArr[1].equals("name"))) {
                rsl = false;
            }
        return rsl;
    }

    public static ArgsNames of(String[] args) {
        ArgsNames names = new ArgsNames();
        names.parse(args);
        return names;
    }
}
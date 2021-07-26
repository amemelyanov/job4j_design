package ru.job4j.io.csvreader;

import java.util.HashMap;
import java.util.Map;

public class Args {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String arg : args) {
            if (!arg.contains("=")) {
                continue;
            }
            String[] argArr = arg.split("=");
            if (!validate(argArr)) {
                throw new IllegalArgumentException("Please check key name or content of parameter."
                        + System.lineSeparator()
                        + "Use: java -jar target/csvReader.jar with parameters, for example: "
                        + "-path=file.csv -delimiter=\";\"  -out=stdout -filter=name,age ");
            }
            values.put(argArr[0].substring(1), argArr[1]);
        }
    }

    private boolean validate(String[] argArr) {
        return ((argArr[0].equals("-path") || argArr[0].equals("-delimiter")
                || argArr[0].equals("-out") || argArr[0].equals("-filter")) && argArr.length > 1);
    }

    public static Args of(String[] args) {
        Args names = new Args();
        names.parse(args);
        return names;
    }
}

package ru.job4j.io.find;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;


public class Find {

    public static Predicate<Path> getSearchCondition(ArgsNames args) {
        Predicate<Path> rsl;
        String type = args.get("t");
        String name = args.get("n");
        Pattern pattern;
        switch (type) {
            case "mask":
                pattern = Pattern.compile(name.replace("?", ".?")
                        .replace("*", ".*"));
                rsl = p -> pattern.matcher(p.toFile().getName()).find();
                break;
            case "name":
                rsl = p -> p.toFile().getName().equals(name);
                break;
            case "regex":
                pattern = Pattern.compile(name);
                rsl = p -> pattern.matcher(p.toFile().getName()).find();
                break;
            default:
                rsl = null;
        }
        return rsl;
    }

    public static void main(String[] args) throws IOException {
        ArgsNames argsNames  = ArgsNames.of(args);
        String path = argsNames.get("d");
        String outFile = argsNames.get("o");
        Path start = Paths.get(path);
        List<Path> pathList = SearchFiles.search(start, getSearchCondition(argsNames));
        Writer writer = new Writer(outFile);
        writer.writeResult(pathList);
    }
}

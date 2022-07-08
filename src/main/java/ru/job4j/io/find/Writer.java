package ru.job4j.io.find;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Writer {
    private final String path;

    public Writer(String path) {
        this.path = path;
    }

    public void writeResult(List<Path> data) {
        if (data.size() == 0) {
            System.out.println("Result of work is empty.");
        }
        try (BufferedWriter out = new BufferedWriter(
                new FileWriter(path, Charset.forName("WINDOWS-1251"), false))) {
            List<String> dataStr = data.stream().map(Path::toString).collect(Collectors.toList());
            for (String str : dataStr) {
                out.write(String.format("%s %s", str, System.lineSeparator()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

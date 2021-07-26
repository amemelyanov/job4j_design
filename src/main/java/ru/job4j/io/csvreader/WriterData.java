package ru.job4j.io.csvreader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class WriterData {
    public static void write(String out, List<String> data) {
        if (out.equalsIgnoreCase("stdout")) {
            data.forEach(System.out::println);
        } else {
            if (data.size() == 0) {
                System.out.println("Result of work is empty.");
            }
            try (BufferedWriter bf = new BufferedWriter(
                    new FileWriter(out, Charset.forName("WINDOWS-1251"), false))) {
                for (String str : data) {
                    bf.write(String.format("%s %s", str, System.lineSeparator()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

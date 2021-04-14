package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        ArrayList<String> rsl = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            String current = "";
            int down = 0;
            while (read.ready()) {
                current = read.readLine();
                if (current.isEmpty()) {
                    continue;
                }
                if (down == 0 && (current.split(" ")[0].equals("400")
                        || current.split(" ")[0].equals("500"))) {
                    rsl.add(current.split(" ")[1]);
                    down = 1;
                }
                if (down == 1 && !current.split(" ")[0].equals("400")
                        && !current.split(" ")[0].equals("500")) {
                    rsl.add(current.split(" ")[1]);
                    down = 0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeLog(rsl, target);
    }

    public void writeLog(List<String> listToWrite, String target) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)))) {
            for (int i = 0; i < listToWrite.size(); i += 2) {
                out.printf("%s;%s%n", listToWrite.get(i), listToWrite.get(i + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("./data/source.log", "./data/target.log");
    }
}
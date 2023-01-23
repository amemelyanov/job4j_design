package ru.job4j.ood.dip;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Text {
    private String text;
    private TextToFile textToFile;

    public Text(String text, TextToFile textToFile) {
        this.text = text;
        this.textToFile = textToFile;
    }

    void save(String file) {
        textToFile.saveToFile(this.text, file);
    }
}

class TextToFile {
    public void saveToFile(String text, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)))) {
            out.printf(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

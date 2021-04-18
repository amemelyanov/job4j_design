package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> phrases = getListAnswers();
        String userInput = "";
        String botAnswer;
        boolean silence = true;
        while (!userInput.equals(OUT)) {
            try (BufferedWriter out = new BufferedWriter(
                    new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            Scanner in = new Scanner(System.in);
            userInput = in.next();
            switch (userInput) {
                case OUT:
                    out.write(String.format("%s%n", userInput));
                    break;
                case STOP:
                    silence = false;
                    out.write(String.format("%s%n", userInput));
                    break;
                case CONTINUE:
                    silence = true;
                    botAnswer = phrases.get((int) (Math.random() * phrases.size()));
                    out.write(String.format("%s%n", userInput));
                    out.write(String.format("%s%n", botAnswer));
                    System.out.println(botAnswer);
                    break;
                default:
                    if (silence) {
                        botAnswer = phrases.get((int) (Math.random() * phrases.size()));
                        out.write(String.format("%s%n", userInput));
                        out.write(String.format("%s%n", botAnswer));
                        System.out.println(botAnswer);
                    } else {
                        out.write(String.format("%s%n", userInput));
                    }
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<String> getListAnswers() {
        List<String> phrases = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(this.botAnswers))) {
            read.lines().forEach(phrases::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/chat_log.data", "./data/chat_phrases.data");
        cc.run();
    }
}
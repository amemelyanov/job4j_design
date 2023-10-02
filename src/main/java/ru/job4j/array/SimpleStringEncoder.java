package ru.job4j.array;

public class SimpleStringEncoder {
    public static String encode(String input) {
        String result = "";
        char symbol = input.charAt(0);
        int counter = 1;
        for (int i = 1; i < input.length(); i++) {
            if (symbol == input.charAt(i)) {
                counter++;
            } else {
                String countStr = counter > 1 ? "" + counter : "";
                result = result + symbol + countStr;
                symbol = input.charAt(i);
                counter = 1;
            }
        }
        String countStr = counter > 1 ? "" + counter : "";
        result = result + symbol + countStr;
        return result;
    }
}
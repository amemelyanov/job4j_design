package ru.job4j.io.csvreader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class CSVReader {
    private static List<Integer> getIndexesFromFilter(String[] filter, List<String> header) {
        List<Integer> result = new ArrayList<>();
        int index;
        for (String s : filter) {
            index = header.indexOf(s);
            if (index != -1) {
                result.add(index);
            }
        }
        Collections.sort(result);
        return result;
    }

    private static String getResultStringFromList(List<Integer> indexes, List<String> line,
                                                  String delimiter) {
        List<String> resultLine = new ArrayList<>();
        for (Integer index : indexes) {
            resultLine.add(line.get(index));
        }
        return String.join(delimiter, resultLine);
    }

    private static List<String> getDataFromScanner(String path, String[] filter,
                                                   String delimiter) throws FileNotFoundException {
        List<String> line;
        List<String> data = new ArrayList<>();
        List<Integer> indexes;

        try (Scanner scanner = new Scanner(new File(path))) {
            line = Arrays.asList(scanner.next().split(delimiter));
            indexes = getIndexesFromFilter(filter, line);
            data.add(getResultStringFromList(indexes, line, delimiter));

            while (scanner.hasNext()) {
                line = Arrays.asList(scanner.next().split(delimiter));
                data.add(getResultStringFromList(indexes, line, delimiter));
            }
        }
        return data;
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 4) {
            throw new IllegalArgumentException("Please check number pairs of keys and parameters."
                    + System.lineSeparator()
                    + "Use: java -jar target/csvReader.jar with parameters, for example: "
                    + "-path=file.csv -delimiter=\";\"  -out=stdout -filter=name,age ");
        }

        Args csvArgs = Args.of(args);
        String path = csvArgs.get("path");
        String delimiter = csvArgs.get("delimiter");
        String out = csvArgs.get("out");
        String[] filter = csvArgs.get("filter").split(",");

        List<String> data = getDataFromScanner(path, filter, delimiter);
        WriterData.write(out, data);
    }
}

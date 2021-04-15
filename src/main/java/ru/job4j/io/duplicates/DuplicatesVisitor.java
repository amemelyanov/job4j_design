package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final HashMap<FileProperty, List<Path>> mapFiles = new HashMap<>();

    public void getDuplicate() {
        for (Map.Entry<FileProperty, List<Path>> entry : mapFiles.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.printf("%s has duplicates: %n", entry.getKey().getName());
                for (Path path : entry.getValue()) {
                    System.out.printf("--- %s%n", path);
                }
            }
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(attrs.size(), file.getFileName().toString());
        if (mapFiles.containsKey(fileProperty)) {
            mapFiles.get(fileProperty).add(file.toAbsolutePath());
        } else {
            mapFiles.put(fileProperty, new ArrayList<>(Collections.singletonList(file.toAbsolutePath())));
        }
        return super.visitFile(file, attrs);
    }
}
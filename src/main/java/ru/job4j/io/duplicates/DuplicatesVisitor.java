package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private static Map<FileProperty, String> storage = new HashMap<>();
    private static Map<FileProperty, String> duplicates = new HashMap<>();

    private static void setDuplicate(Path file) {
        FileProperty fp = new FileProperty(file.toFile().length(), file.getFileName().toString());
        StringBuilder rsl = new StringBuilder();
        if (duplicates.containsKey(fp)) {
            rsl.append(duplicates.get(fp));
        } else {
            rsl.append(storage.get(fp));
        }
        rsl.append(System.lineSeparator())
                .append(file.toAbsolutePath().toString());
        duplicates.put(fp, rsl.toString());
    }

    public static Map<FileProperty, String> getDuplicates() {
        return duplicates;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fp = new FileProperty(file.toFile().length(), file.getFileName().toString());
        if (storage.putIfAbsent(fp, file.toAbsolutePath().toString()) != null) {
            setDuplicate(file);
        }
        return super.visitFile(file, attrs);
    }
}

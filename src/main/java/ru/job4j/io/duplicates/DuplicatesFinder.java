package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class DuplicatesFinder {
    private Path root;
    private Map<FileProperty, String> duplicates = new HashMap<>();


    public DuplicatesFinder(String[] args) {
        getPath(args);
    }

    private void getPath(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments is null");
        }
        Stream.of(args)
                .findFirst()
                .ifPresent(x -> root = Paths.get(x));
        if (!root.toFile().isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", root.toAbsolutePath().toString()));
        }
    }

    private void findDuplicates() throws IOException {
        Files.walkFileTree(root, new DuplicatesVisitor());
        duplicates = DuplicatesVisitor.getDuplicates();
    }

    @Override
    public String toString() {
        if (duplicates == null) {
            return "There is no duplicates in directory";
        }
        StringBuilder rsl = new StringBuilder();
        duplicates.forEach((k, v) -> rsl.append(k)
                .append(" :")
                .append(System.lineSeparator())
                .append(v)
                .append(System.lineSeparator())
                .append(System.lineSeparator()));
        return rsl.toString();
    }

    public static void main(String[] args) throws IOException {
        DuplicatesFinder dp = new DuplicatesFinder(args);
        dp.findDuplicates();
        System.out.println(dp);
    }
}

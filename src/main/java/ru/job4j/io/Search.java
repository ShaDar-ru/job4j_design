package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {

    public static void validate(String[] args) throws IllegalArgumentException {
        if (args.length != 2) {
            throw new IllegalArgumentException(
                    "Invalid input data. Usage java -jar search.jar <ROOT_FOLDER> <SEARCHED_FILE_TYPE>.");
        }
        Path start = Paths.get(args[0]);
        if (!start.toFile().isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", start.toAbsolutePath()));
        }
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPath();
    }

    public static void searchind(String[] args) throws IOException {
        Path start = Paths.get(args[0]);
        String searchedFileType = args[1];
        search(start, p -> p.toFile()
                .getName()
                .endsWith(searchedFileType))
                .forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        validate(args);
        searchind(args);
    }
}

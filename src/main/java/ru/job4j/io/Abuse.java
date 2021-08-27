package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 26.08.2021
 */
public class Abuse {

    public static void drop(String source, String target, List<String> words) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            in.lines()
                    .flatMap(line -> Stream.of(line.split("\\s+")))
                    .filter(word -> !words.contains(word))
                    .map(word -> word + " ")
                    .forEach(out::println);
        }
    }
}

package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 25.08.2021
 */
public class LogFilter {
    /**
     * Согласно заданию, нужно вернуть строки где 404 - предпоследнее слово. Но, если обратить внимание, в других местах
     * подстрока 404 не существует, таким образом этот метод отлично подойдет.
     *
     * @param file input File
     * @return log List
     */
    public static List<String> filter404(String file) {
        List<String> list = readFile(file);
        List<String> log = new ArrayList<>();
        list.forEach(x -> {
            if (x.contains("404")) {
                log.add(x);
            }
        });
        return log;
    }

    /**
     * Данный метод полностью соответствует условиям задачи.
     *
     * @param file input File
     * @return log List
     */
    public static List<String> filter(String file) {
        List<String> list = readFile(file);
        List<String> log = new ArrayList<>();
        list.forEach(x -> {
            if (x.contains("404")) {
                String[] s = x.split(" ");
                if (s[s.length - 2].equals("404")) {
                    log.add(x);
                }
            }
        });
        return log;
    }


    private static List<String> readFile(String file) {
        List<String> text = new ArrayList<>();
        try (BufferedReader bfr = new BufferedReader(new FileReader(file))) {
            bfr.lines().forEach(text::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
        log = filter404("log.txt");
        System.out.println(log);
    }
}

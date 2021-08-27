package ru.job4j.io;

import java.io.File;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 27.08.2021
 */
public class Dir {
    public static void main(String[] args) {
        File file = new File("/home/alex/projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.printf("Name : %s%n", file.getName());
        System.out.printf("Size : %s%n", file.length());
    }
}

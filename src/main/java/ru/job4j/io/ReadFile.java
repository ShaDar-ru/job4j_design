package ru.job4j.io;

import java.io.FileInputStream;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 25.08.2021
 */
public class ReadFile {
    public static void printText(StringBuilder text) {
        String[] lines = text.toString().split(System.lineSeparator());
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static StringBuilder readFile() {
        StringBuilder text = new StringBuilder();
        try (FileInputStream in = new FileInputStream("input.txt")) {
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    public static void main(String[] args) {
        StringBuilder text = readFile();
        printText(text);
    }
}

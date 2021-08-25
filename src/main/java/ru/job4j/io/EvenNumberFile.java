package ru.job4j.io;

import java.io.FileInputStream;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 25.08.2021
 */
public class EvenNumberFile {
    private static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void printText(StringBuilder text) {
        String[] lines = text.toString().split(System.lineSeparator());
        for (String s : lines) {
            if (!s.equals("")) {
                int a = Integer.parseInt(s);
                System.out.println(isEven(a));
            }
        }
    }

    public static StringBuilder readFile() {
        StringBuilder txt = new StringBuilder();
        try (FileInputStream in = new FileInputStream("event.txt")) {
            int read;
            while ((read = in.read()) != -1) {
                txt.append((char) read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return txt;
    }

    public static void main(String[] args) {
        printText(readFile());
    }
}

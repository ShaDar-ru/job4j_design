package ru.job4j.scanner;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 02.09.2021
 */
public class ScannerExample1 {
    public static void main(String[] args) {
        var ls = System.lineSeparator();
        var data = String.join(ls,
                "1 2 3",
                "4 5 6",
                "7 8 9"
        );
        var str = data.toString();
        var scanner = new Scanner(
                new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8)));
        while (scanner.hasNextInt()) {
            System.out.print(scanner.nextInt());
            System.out.print(" ");
        }
    }
}

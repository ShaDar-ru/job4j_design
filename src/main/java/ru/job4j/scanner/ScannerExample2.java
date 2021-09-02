package ru.job4j.scanner;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 02.09.2021
 */
public class ScannerExample2 {
    public static void main(String[] args) {
        var data = "empl1@mail.ru, empl2@mail.ru, empl3@mail.ru";
        var scanner = new Scanner(new ByteArrayInputStream(data.getBytes()))
                .useDelimiter(", ");
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}

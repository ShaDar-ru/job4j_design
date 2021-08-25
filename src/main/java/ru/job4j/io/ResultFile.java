package ru.job4j.io;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 25.08.2021
 */
public class ResultFile {
    public static int[][] multiply(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }

    public static void main(String[] args) {
        int[][] table = multiply(9);
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int[] i : table) {
                for (int j : i) {
                    if (j / 10 < 1) {
                        out.write(("  " + j).getBytes());
                    } else {
                        out.write((" " + j).getBytes());
                    }
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

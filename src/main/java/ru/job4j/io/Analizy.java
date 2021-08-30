package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 26.08.2021
 */
public class Analizy {
    public void unavailable(String source, String target) {
        StringBuilder stbl = readFile(source);
        writeFile(stbl, target);
    }

    private StringBuilder readFile(String source) {
        StringBuilder stbl = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            reader.lines().forEach(x -> {
                if ((stbl.length() == 0 || stbl.charAt(stbl.length() - 1) != ';')
                        && (x.contains("400") || x.contains("500"))) {
                    String[] strings = x.split(" ");
                    stbl.append(strings[1] + ";");
                }
                if (stbl.length() != 0 && stbl.charAt(stbl.length() - 1) == ';'
                        && (x.contains("200") || x.contains("300"))) {
                    String[] strings = x.split(" ");
                    stbl.append(strings[1] + ";" + System.lineSeparator());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stbl;
    }

    private void writeFile(StringBuilder data, String target) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Analizy an = new Analizy();
        an.unavailable("./data/server.log", "./data/serverOutPut.txt");
    }
}

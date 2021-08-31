package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 25.08.2021
 */
public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            String s = read.readLine();
            while (s != null) {
                if (!s.contains("#") && s.contains("=")) {
                    String[] str = s.split("=");
                    if (str.length != 2) {
                        throw new IllegalArgumentException("Invalid data");
                    }
                    if (values.get(str[0]) != null) {
                        throw new IllegalArgumentException("Invalid data. Duplicated keys");
                    }
                    values.put(str[0], str[1]);
                }
                s = read.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        if (!values.containsKey(key) || values.get(key) == null) {
            throw new IllegalArgumentException("Invalid data");

        }
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}

package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 30.08.2021
 */
public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("Arguments not found.");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String s : args) {
            s = s.substring(1);
            s = s.replace(" ", "");
            String[] str = s.split("=");
            if (str.length <= 1 || str[1].equals("")) {
                throw new IllegalArgumentException("Arguments not found.");
            }
            values.put(str[0], str[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        jvm = ArgsName.of(new String[]{"-Xmx= ", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("Xmx"));
    }
}

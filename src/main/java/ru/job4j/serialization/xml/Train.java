package ru.job4j.serialization.xml;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 09.09.2021
 */
public class Train {
    private final String name;
    private final int number;

    public Train(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Train{"
                + "name=" + name
                + ", number=" + number
                + "}";
    }
}

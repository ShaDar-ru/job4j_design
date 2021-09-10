package ru.job4j.serialization.json;

import java.util.Arrays;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 09.09.2021
 */
public class Train {
    private final String name;
    private final int number;
    private final double fuelConsumption;

    public Train(String name, int number, double fuelConsumption) {
        this.name = name;
        this.number = number;
        this.fuelConsumption = fuelConsumption;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public String toString() {
        return "Train{"
                + "name=" + name
                + ", number=" + number
                + ", fuelConsumption=" + fuelConsumption
                + "}";
    }
}

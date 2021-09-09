package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 09.09.2021
 */
public class TrainPath {
    private final Train train;
    private final String[] stations;
    private final boolean oneWay;

    public TrainPath(Train train, boolean oneWay, String... stations) {
        this.train = train;
        this.oneWay = oneWay;
        this.stations = stations;
    }

    @Override
    public String toString() {
        return "TrainPath{"
                + "train=" + train
                + ", oneWay=" + oneWay
                + ", stations=" + Arrays.toString(stations)
                + "}";
    }

    public static void main(String[] args) {
        final TrainPath path = new TrainPath(
                new Train("Поезд", 28, 0.2),
                true, "Санкт-Петербург", "Великий Новгород", "Москва");
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(path));
        final String trainPathJson =
                "{"
                        + "\"train\":"
                        + "{"
                        + "\"name\":\"Поезд\","
                        + "\"number\":28,"
                        + "\"fuelConsumption\":0.2"
                        + "},"
                        + "\"oneWay\":true,"
                        + "\"stations\":"
                        + "[\"Санкт-Петербург\",\"Великий Новгород\",\"Москва\"]"
                        + "}";
        final TrainPath pathFromJson = gson.fromJson(trainPathJson, TrainPath.class);
        System.out.println(pathFromJson);
    }
}

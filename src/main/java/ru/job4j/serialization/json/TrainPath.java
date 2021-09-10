package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public Train getTrain() {
        return train;
    }

    public String[] getStations() {
        return stations;
    }

    public boolean isOneWay() {
        return oneWay;
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
//        final TrainPath path = new TrainPath(
//                new Train("Поезд", 28, 0.2),
//                true, "Санкт-Петербург", "Великий Новгород", "Москва");
//        final Gson gson = new GsonBuilder().create();
//        System.out.println(gson.toJson(path));
//        final String trainPathJson =
//                "{"
//                        + "\"train\":"
//                        + "{"
//                        + "\"name\":\"Поезд\","
//                        + "\"number\":28,"
//                        + "\"fuelConsumption\":0.2"
//                        + "},"
//                        + "\"oneWay\":true,"
//                        + "\"stations\":"
//                        + "[\"Санкт-Петербург\",\"Великий Новгород\",\"Москва\"]"
//                        + "}";
//        final TrainPath pathFromJson = gson.fromJson(trainPathJson, TrainPath.class);
//        System.out.println(pathFromJson);
        //***Ручная генерация JSON***
        //Создаем поезд, для генерации его JSON-файла
        final Train train = new Train("Поезд", 28, 0.2);
        //Создаем путь
        final TrainPath path = new TrainPath(
                train, true, "Санкт-Петербург", "Великий Новгород", "Москва");
        //Новый (пустой) JSON объкт
        JSONObject jsonPath = new JSONObject();
        //Создаем и заполняем массив
        List<String> list = new ArrayList<>(Arrays.asList(path.getStations()));
        JSONArray stations = new JSONArray(list);
        //Заполняем элементы JSON-файла
        jsonPath.put("train", new JSONObject(train));
        jsonPath.put("oneWay", path.isOneWay());
        jsonPath.put("stations", stations);
        //
        System.out.println(jsonPath);

        //***Автогенерация JSON-файла, по объекту POJO***
        System.out.println(new JSONObject(path));
    }
}

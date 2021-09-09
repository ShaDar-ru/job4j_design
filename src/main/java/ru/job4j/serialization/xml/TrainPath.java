package ru.job4j.serialization.xml;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 09.09.2021
 */
public class TrainPath {
    private final Train train;
    private final String[] stations;
    private final boolean oneWay;
    private final String sl = System.lineSeparator();
    private final String tab = "    ";

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

    public String toXML() {
        List<String> returnedStr = Arrays.stream(stations)
                .map(x -> tab + tab + "<station>" + x + "</station>" + sl)
                .collect(Collectors.toList());
        StringBuilder stbl = new StringBuilder();
        stbl.append("<?xml version=\"1.1\" encoding=\"UTF-8\" ?>").append(sl)
                .append("<train_path>").append(sl)
                .append(tab).append("<train>").append(sl)
                .append(tab).append(tab).append("<name=\"").append(train.getName()).append("\"/>").append(sl)
                .append(tab).append(tab).append("<number=").append(train.getNumber()).append("/>").append(sl)
                .append(tab).append("</train>").append(sl)
                .append(tab).append("<one_way=").append(oneWay).append("/>").append(sl)
                .append(tab).append("<stations>").append(sl);
        for (String s : returnedStr) {
            stbl.append(s);
        }
        stbl.append(tab).append("</stations>").append(sl).append("</train_path>");
        return stbl.toString();
    }

    public static void main(String[] args) {
        final TrainPath path = new TrainPath(
                new Train("Поезд", 28),
                true, "Санкт-Петербург", "Великий Новгород", "Москва");
        System.out.println(path.toXML());
    }
}

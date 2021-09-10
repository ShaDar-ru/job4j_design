package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 09.09.2021
 */

@XmlRootElement(name = "train")
@XmlAccessorType(XmlAccessType.FIELD)
public class Train {
    private String name;
    private int number;

    public Train() {

    }

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

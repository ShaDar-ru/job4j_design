package ru.job4j.generics;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 08.07.2021
 */
public abstract class Base {
    private final String id;

    public Base(final String id) {
        this.id = id;
    }

    public String getId(){
        return id;
    }
}

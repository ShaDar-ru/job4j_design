package ru.job4j.generics;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 04.07.2021
 */
public class SimpleArray<T> implements Iterable<T> {
    private T[] models;
    private int point = 0;

    public SimpleArray(int size) {
        this.models = (T[]) new Object[size];
    }

    public void add(T model) {
        if (point < models.length) {
            models[point++] = model;
        }
    }

    public void set(int index, T model) {
        models[Objects.checkIndex(index, point)] = model;
    }

    public void remove(int index) {
        int removeInd = Objects.checkIndex(index, point);
        System.arraycopy(models, removeInd, models, removeInd, models.length-removeInd);
        point--;
    }

    public T get(int index) {
        return models[Objects.checkIndex(index, point)];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int itPoint = 0;

            @Override
            public boolean hasNext() {
                return itPoint < point;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return models[itPoint++];
            }
        };
    }
}

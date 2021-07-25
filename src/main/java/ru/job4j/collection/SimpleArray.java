package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private T[] models;
    private int point = 0;
    private int modCount = 0;

    public SimpleArray() {
        this.models = (T[]) new Object[0];
    }

    public SimpleArray(int size) {
        this.models = (T[]) new Object[size];
    }

    public T get(int index) {
        Objects.checkIndex(index, point);
        return models[index];
    }

    public void add(T model) {
        modCount++;
        if (models.length == 0) {
            this.models = (T[]) new Object[1];
        }
        if (point == models.length) {
            models = Arrays.copyOf(models, (models.length * 2));
        }
        models[point++] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, point);
        models[index] = null;
        modCount++;
        System.arraycopy(models, index + 1, models, index, models.length - index - 1);
        point--;
    }

    public boolean remove(T model) {
        for (int i = 0; i < models.length; i++) {
            if (models[i].equals(model)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public int size() {
        return point;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int itPoint = 0;
            private int modIt = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != modIt) {
                    throw new ConcurrentModificationException();
                }
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

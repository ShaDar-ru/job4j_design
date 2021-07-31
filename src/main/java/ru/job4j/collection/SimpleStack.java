package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<>();
    private int size = 0;

    public T pop() {
        T rsl = linked.deleteFirst();
        size--;
        return rsl;
    }

    public void push(T value) {
        linked.addFirst(value);
        size++;
    }

    public int size() {
        return size;
    }
}

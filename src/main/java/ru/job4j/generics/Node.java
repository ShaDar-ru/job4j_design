package ru.job4j.generics;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 04.07.2021
 */
public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }
}

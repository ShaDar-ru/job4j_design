package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 27.07.2021
 */
public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T t) {
        Node<T> node = new Node<>(t, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> deleted = head;
        head = head.next;
        deleted.next = null;
        return deleted.data;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T rsl = node.data;
                node = node.next;
                return rsl;
            }
        };
    }

    private static class Node<T> {
        private Node<T> next;
        private T data;

        public Node(T data, Node<T> next) {
            this.next = next;
            this.data = data;
        }
    }
}

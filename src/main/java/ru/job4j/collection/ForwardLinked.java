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

    public void addFirst(T t) {
        Node<T> node = new Node<>(t, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        head = node;
        node.next = tail;
    }

    public boolean revert() {
        if (head == null || head.next == null) {
            return false;
        }
        Node<T> newHead = null;
        Node<T> newTail = new Node<>(head.data, null);
        while (head.next != null) {
            head = head.next;
            newHead = new Node<>(head.data, newTail);
            newTail = newHead;
        }
        head = newHead;
        return true;
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

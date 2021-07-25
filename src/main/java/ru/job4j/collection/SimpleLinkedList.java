package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int point = 0;
    private int modCount = 0;

    @Override
    public void add(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        if (l == null) {
            first = newNode;
            last = first;
        } else {
            l.next = newNode;
        }
        point++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, point);
        Node<E> rsl = first;
        for (int i = 0; i < index; i++) {
            rsl = rsl.getNext();
        }
        return rsl.getData();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator() {
            final int modIt = modCount;
            Node<E> lastReturned = first;
            int pointIt = 0;

            @Override
            public boolean hasNext() {
                if (modIt != modCount) {
                    throw new ConcurrentModificationException();
                }
                return pointIt < point;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> temp = lastReturned;
                lastReturned = lastReturned.getNext();
                pointIt++;
                return temp.data;
            }
        };
    }

    private class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> before;

        public Node(Node<E> before, E data, Node<E> next) {
            this.before = before;
            this.data = data;
            this.next = next;
        }

        public Node<E> getBefore() {
            return this.before;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public E getData() {
            return this.data;
        }
    }
}

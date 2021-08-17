package ru.job4j.collection.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 16.08.2021
 */
public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        int inputHash = key.hashCode();
        int inputPos = indexFor(inputHash);
        if (table[inputPos] != null) {
            return false;
        }
        MapEntry<K, V> element = new MapEntry<>(key, value);
        table[inputPos] = element;
        modCount++;
        count++;
        if ((float) (count / capacity) >= LOAD_FACTOR) {
            expand();
        }
        return true;
    }

    @Override
    public V get(K key) {
        int hashSearched = hash(key.hashCode());
        int indexFor = indexFor(hashSearched);
        if (table[indexFor] == null || !table[indexFor].getKey().equals(key)) {
            return null;
        }
        return table[indexFor].getValue();
    }

    @Override
    public boolean remove(K key) {
        int hashSearched = hash(key.hashCode());
        int indexFor = indexFor(hashSearched);
        if (table[indexFor] == null) {
            return false;
        }
        if (!table[indexFor].getKey().equals(key)) {
            return false;
        }
        table[indexFor(hashSearched)] = null;
        modCount++;
        count--;
        return true;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int itPoint = 0;
            private int itCapacity = capacity;
            private int itModCount = modCount;

            @Override
            public boolean hasNext() {
                if (itModCount != modCount) {
                    throw new ConcurrentModificationException("Map was changed!");
                }
                while (itPoint < itCapacity) {
                    if (table[itPoint] != null) {
                        return true;
                    }
                    itPoint++;
                }
                return false;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No Items");
                }
                return table[itPoint++].getKey();
            }
        };
    }

    private int hash(int hashCode) {
        if (hashCode == 0) {
            return 0;
        }
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] temp = new MapEntry[capacity];
        for (int i = 0; i < capacity / 2; i++) {
            if (table[i] != null) {
                int hashCode = table[i].getKey().hashCode();
                int indexNew = indexFor(hash(hashCode));
                temp[indexNew] = table[i];
            }
        }
        table = temp;
    }


    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }
    }
}

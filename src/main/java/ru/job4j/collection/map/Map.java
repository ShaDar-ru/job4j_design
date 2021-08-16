package ru.job4j.collection.map;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 16.08.2021
 */
public interface Map<K, V> extends Iterable<K> {
    boolean put(K key, V value);

    V get(K key);

    boolean remove(K key);
}

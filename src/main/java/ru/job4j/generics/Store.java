package ru.job4j.generics;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 08.07.2021
 */
public interface Store<T extends Base> {
    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}

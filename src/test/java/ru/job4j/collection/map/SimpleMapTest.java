package ru.job4j.collection.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 16.08.2021
 */
public class SimpleMapTest {

    @Test
    public void whenPutOneElem() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        assertThat(map.put("1", 1), is(true));
    }

    @Test
    public void whenPutTwoElem() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("1", 1);
        assertThat(map.put("2", 2), is(true));
    }

    @Test
    public void whenPutElemsMoreThanCapacity() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        assertThat(map.put("1", 1), is(true));
        assertThat(map.put("2", 2), is(true));
        assertThat(map.put("3", 3), is(true));
        assertThat(map.put("4", 4), is(true));
        assertThat(map.put("5", 5), is(true));
        assertThat(map.put("6", 6), is(true));
        assertThat(map.put("7", 7), is(true));
        assertThat(map.put("8", 8), is(true));
        assertThat(map.put("9", 9), is(true));
    }

    @Test
    public void whenGetOneCorrectElem() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("1", 1);
        map.put("2", 2);
        assertThat(map.get("1"), is(1));
    }

    @Test
    public void whenGetOneUnCorrectElem() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("1", 1);
        map.put("2", 2);
        assertNull(map.get("3"));
    }

    @Test
    public void whenRemoveCorrectElem() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("1", 1);
        assertThat(map.remove("1"), is(true));
    }

    @Test
    public void whenRemoveUnCorrectElem() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        assertThat(map.remove("1"), is(false));
    }

    @Test
    public void whenUseIterator() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("1", 1);
        map.put("2", 2);
        Iterator<String> it = map.iterator();
        assertThat(it.hasNext(), is(true));
        assertNotNull(it.next());
        assertThat(it.hasNext(), is(true));
        assertNotNull(it.next());
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenTestFailFastIt() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("1", 1);
        map.put("2", 2);
        Iterator<String> it = map.iterator();
        assertThat(it.hasNext(), is(true));
        assertNotNull(it.next());
        assertThat(it.hasNext(), is(true));
        assertNotNull(it.next());
        map.put("3", 3);
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenTestEmptyIt() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        Iterator<String> it = map.iterator();
        assertThat(it.hasNext(), is(false));
        assertNotNull(it.next());
    }
}
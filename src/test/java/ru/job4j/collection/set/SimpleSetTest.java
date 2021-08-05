package ru.job4j.collection.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenHasNext() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        Iterator<Integer> i = set.iterator();
        assertThat(i.hasNext(), is(true));
        assertThat(i.next(), is(1));
        assertFalse(i.hasNext());
    }

    @Test
    public void whenAddTwoEqualElements() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(1);
        Iterator<Integer> i = set.iterator();
        assertThat(i.hasNext(), is(true));
        assertThat(i.next(), is(1));
        assertThat(i.hasNext(), is(true));
        assertThat(i.next(), is(2));
        assertFalse(i.hasNext());
    }

    @Test
    public void whenContains() {
        Set<String> set = new SimpleSet<>();
        set.add("One");
        set.add("Two");
        assertTrue(set.contains("One"));
        assertFalse(set.contains("two"));
    }
}
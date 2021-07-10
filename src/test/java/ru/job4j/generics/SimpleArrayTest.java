package ru.job4j.generics;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 04.07.2021
 */
public class SimpleArrayTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenCreate() {
        SimpleArray<Integer> ints = new SimpleArray<>(10);
        ints.get(0);
    }

    @Test
    public void whenGetFirst() {
        SimpleArray<Integer> ints = new SimpleArray<>(1);
        ints.add(12);
        assertThat(ints.get(0), is(12));
    }

    @Test
    public void whenGetSome() {
        SimpleArray<Integer> ints = new SimpleArray<>(10);
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        assertThat(ints.get(0), is(1));
        assertThat(ints.get(1), is(2));
        assertThat(ints.get(2), is(3));
        assertThat(ints.get(3), is(4));
    }

    @Test
    public void whenSetOneOfSome() {
        SimpleArray<Integer> ints = new SimpleArray<>(10);
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.set(1, 3);
        assertThat(ints.get(0), is(1));
        assertThat(ints.get(1), is(3));
        assertThat(ints.get(2), is(3));
    }

    @Test
    public void whenSetOneOfSome2() {
        SimpleArray<Integer> ints = new SimpleArray<>(10);
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.set(2, 4);
        assertThat(ints.get(0), is(1));
        assertThat(ints.get(1), is(2));
        assertThat(ints.get(2), is(4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenSetOneOutOfIndexes() {
        SimpleArray<Integer> ints = new SimpleArray<>(10);
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.set(5, 12);
        assertThat(ints.get(0), is(1));
        assertThat(ints.get(1), is(2));
        assertThat(ints.get(2), is(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenRemove() {
        SimpleArray<Integer> ints = new SimpleArray<>(10);
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.remove(2);
        assertThat(ints.get(0), is(1));
        assertThat(ints.get(1), is(2));
        assertNull(ints.get(2));
    }

    @Test
    public void whenAddSomeAndRemoveAndAdd() {
        SimpleArray<Integer> ints = new SimpleArray<>(3);
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.remove(1);
        assertThat(ints.get(0), is(1));
        assertThat(ints.get(1), is(3));
        ints.add(14);
        assertThat(ints.get(2), is(14));
    }

    @Test
    public void whenIteratorHasNext() {
        SimpleArray<Integer> ints = new SimpleArray<>(3);
        ints.add(1);
        ints.add(2);
        ints.add(3);
        Iterator<Integer> it = ints.iterator();
        assertTrue(it.hasNext());
    }

    @Test
    public void whenIteratorGetNext() {
        SimpleArray<Integer> ints = new SimpleArray<>(3);
        ints.add(1);
        ints.add(2);
        ints.add(3);
        Iterator<Integer> it = ints.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertFalse(it.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorHasntNext() {
        SimpleArray<Integer> ints = new SimpleArray<>(10);
        ints.add(1);
        ints.add(2);
        ints.add(3);
        Iterator<Integer> it = ints.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        it.next();
    }

    @Test
    public void whenMultiClasses() {
        SimpleArray<String> strings = new SimpleArray<>(1);
        strings.add("one");
        SimpleArray<Integer> ints = new SimpleArray<>(1);
        ints.add(1);
        SimpleArray<Float> floats = new SimpleArray<>(1);
        floats.add(1.0f);
        assertThat(strings.get(0), is("one"));
        assertThat(ints.get(0), is(1));
        assertThat(floats.get(0), is(1.0f));
    }
}
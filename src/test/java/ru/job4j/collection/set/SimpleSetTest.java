package ru.job4j.collection.set;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
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

    @Test(expected = NoSuchElementException.class)
    public void testIterator() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        Iterator<Integer> it = set.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemove() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(null));
        assertTrue(set.add(2));
        assertFalse(set.add(null));
        assertTrue(set.contains(null));
        assertTrue(set.remove(2));
        assertTrue(set.remove(null));
        assertFalse(set.contains(null));
        Iterator<Integer> it = set.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }
}
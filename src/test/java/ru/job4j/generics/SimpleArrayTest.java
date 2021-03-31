package ru.job4j.generics;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {
    private SimpleArray<Integer> simpleArray;

    @Before
    public void setUp() {
        simpleArray = new SimpleArray<>(10);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
    }

    @Test
    public void testAdd() {
        simpleArray.add(null);
        assertThat(simpleArray.getSize(), is(4));
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is(2));
        assertThat(simpleArray.get(2), is(3));
        assertNull(simpleArray.get(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet() {
        assertThat(simpleArray.getSize(), is(3));
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is(2));
        assertThat(simpleArray.get(2), is(3));
        simpleArray.get(4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet() {
        simpleArray.set(1, 4);
        assertThat(simpleArray.getSize(), is(3));
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is(4));
        assertThat(simpleArray.get(2), is(3));
        simpleArray.set(4, 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemove() {
        simpleArray.remove(1);
        assertThat(simpleArray.getSize(), is(2));
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is(3));
        simpleArray.remove(4);
    }

    @Test(expected = NoSuchElementException.class)
    public void testIterator() {
        Iterator<Integer> it = simpleArray.iterator();
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(1));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(2));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(3));
        assertThat(it.hasNext(), Is.is(false));
        it.next();
    }

}

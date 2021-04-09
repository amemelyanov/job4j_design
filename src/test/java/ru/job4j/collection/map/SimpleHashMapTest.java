package ru.job4j.collection.map;

import org.junit.Test;

import static org.hamcrest.Matchers.is;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import ru.job4j.collection.map.SimpleHashMap.Node;

import static org.junit.Assert.*;

public class SimpleHashMapTest {
    @Test
    public void testInsert() {
        Map<String, Integer> map = new SimpleHashMap<>();
        assertTrue(map.insert("1", 1));
        Iterator<Node<String, Integer>> it = map.iterator();
        SimpleHashMap.Node<String, Integer> node = it.next();
        assertThat(node.getKey(), is("1"));
    }

    @Test
    public void testGet() {
        Map<String, Integer> map = new SimpleHashMap<>();
        assertTrue(map.insert("1", 1));
        assertThat(map.get("1"), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void testDelete() {
        Map<String, Integer> map = new SimpleHashMap<>();
        assertTrue(map.insert("1", 1));
        assertTrue(map.delete("1"));
        Iterator<Node<String, Integer>> it = map.iterator();
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedItWhenInsert() {
        Map<String, Integer> map = new SimpleHashMap<>();
        assertTrue(map.insert("1", 1));
        assertTrue(map.insert("2", 2));
        Iterator<Node<String, Integer>> it = map.iterator();
        assertTrue(map.insert("3", 3));
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedItWhenDelete() {
        Map<String, Integer> map = new SimpleHashMap<>();
        assertTrue(map.insert("1", 1));
        assertTrue(map.insert("2", 2));
        Iterator<Node<String, Integer>> it = map.iterator();
        assertTrue(map.delete("1"));
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoSuchElementForIterate() {
        Map<String, Integer> map = new SimpleHashMap<>();
        assertTrue(map.insert("1", 1));
        Iterator<Node<String, Integer>> it = map.iterator();
        it.next();
        it.next();
    }

    @Test
    public void whenResize() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>(4);
        assertThat(map.getCapacity(), is(4));
        map.insert("1", 1);
        map.insert("2", 2);
        map.insert("3", 3);
        map.insert("4", 4);
        assertThat(map.getCapacity(), is(8));
    }

}

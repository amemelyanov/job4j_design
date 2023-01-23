package ru.job4j.collection.map;

public interface Map<K, V> extends Iterable<SimpleHashMap.Node<K, V>> {
    boolean insert(K key, V value);

    V get(K key);

    boolean delete(K key);
}

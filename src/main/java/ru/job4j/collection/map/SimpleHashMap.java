package ru.job4j.collection.map;

import java.util.*;

public class SimpleHashMap<K, V> implements Map<K, V> {
    private Node<K, V>[] table;
    private int modCount;
    private float threshold;
    private int size;
    private int capacity;
    private final float loadFactor = 0.75f;

    public SimpleHashMap() {
         table = new Node[16];
         threshold = table.length * loadFactor;
    }

    public SimpleHashMap(int capacity) {
        this.capacity = capacity;
        table = new Node[capacity];
        threshold = table.length * loadFactor;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean insert(K key, V value) {
        int hash = hash(key);
        int index = hash % table.length;
        Node<K, V> current = table[index];
        if (current != null) {
            if (Objects.equals(key, current.getKey())) {
                current.setValue(value);
            } else {
               return false;
            }
        } else {
            table[index] = new Node<>(hash, key, value);
            if (size + 1 > threshold) {
                threshold *= 2;
                tableResize();
            }
            size++;
            modCount++;
        }
    return true;
    }

    @Override
    public V get(K key) {
        int index = hash(key) % table.length;
        Node<K, V> current = table[index];
        if (current != null && Objects.equals(current.getKey(), key)) {
            return current.getValue();
        }
        return null;
    }

    @Override
    public boolean delete(K key) {
        int hash = hash(key);
        int index = hash % table.length;
        Node<K, V> current = table[index];
        if (current != null && Objects.equals(current.getKey(), key)) {
            table[index] = null;
            size--;
            modCount++;
            return true;
        }
        return false;
    }

    static int hash(Object key) {
        int h = key.hashCode();
        return (key == null) ? 0 : h ^ (h >>> 16);
    }

    private void tableResize() {
        Node<K, V>[] oldTable = table;
        capacity = oldTable.length * 2;
        table = new Node[capacity];
        size = 0;
        for (Node<K, V> node : oldTable) {
            if (node != null) {
                insert(node.key, node.value);
            }
        }
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private int point;

            @Override
            public boolean hasNext() {
                while (point < table.length && table[point] == null) {
                    point++;
                }
                return point < table.length;
            }

            public Node<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return table[point++];
            }
        };
    }

    public static class Node<K, V> {
        private final int hash;
        private final K key;
        private V value;

        public Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public final int hashCode() {
            return 31 * (Objects.hashCode(key) ^ Objects.hashCode(value));
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Node) {
                Node<K, V> node = (Node<K, V>) obj;
                if (Objects.equals(key, node.getKey())
                        && Objects.equals(value, node.getValue())) {
                    return true;
                }
            }
            return false;
        }

    }
}

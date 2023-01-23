package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private T[] data;
    private int size;
    private int modCount;

    public SimpleArray() {
        data = (T[]) new Object[10];
    }

    public SimpleArray(int capacity) {
        data = (T[]) new Object[capacity];
    }

    public T get(int index) {
        return data[Objects.checkIndex(index, size)];
    }

    public void add(T model) {
        if (size == data.length) {
            arrayGrow();
        }
        data[size++] = model;
        modCount++;
    }

    private void arrayGrow() {
        data = Arrays.copyOf(data, data.length + data.length / 2);
    }

    public void remove(int index) {
        int tempIndex = Objects.checkIndex(index, size);
        System.arraycopy(data, tempIndex + 1, data, tempIndex, size - tempIndex - 1);
        data[--size] = null;
        modCount++;
    }

    public void set(int index, T model) {
        data[Objects.checkIndex(index, size)] = model;
        modCount++;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int point = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return data[point++];
            }
        };
    }
}
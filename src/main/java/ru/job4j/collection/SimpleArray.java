package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

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
            T[] tempArray = (T[]) new Object[data.length + data.length / 2];
            System.arraycopy(data, 0, tempArray, 0, data.length);
            data = tempArray;
        }
        data[size++] = model;
        modCount++;
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
            int point = 0;
            final int expectedModCount = modCount;

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
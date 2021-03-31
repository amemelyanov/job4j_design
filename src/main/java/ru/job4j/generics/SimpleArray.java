package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] data;
    private int size;

    public SimpleArray(int capacity) {
        data = (T[]) new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    public void add(T model) {
        data[size++] = model;
    }

    public T get(int index) {
        return data[Objects.checkIndex(index, size)];
    }

    public void set(int index, T model) {
            data[Objects.checkIndex(index, size)] = model;
    }

    public void remove(int index) {
        int tempIndex = Objects.checkIndex(index, size);
        System.arraycopy(data, tempIndex + 1, data, tempIndex, size - tempIndex - 1);
        data[--size] = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int point = 0;
            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return data[point++];
            }
        };
    }
}

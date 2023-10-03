package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class NonNullIterator implements Iterator<Integer> {

    private final Integer[] data;
    private int index;

    public NonNullIterator(Integer[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean hasNonNull = false;
        for (int i = index; i < data.length; i++) {
            if (data[i] != null) {
                hasNonNull = true;
                index = i;
                break;
            }
        }
        return hasNonNull;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No such element");
        }
        return data[index++];
    }
}
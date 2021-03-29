package ru.job4j.iterator;

import java.util.*;

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean hasEven = false;
        for (int i = point; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                hasEven = true;
                point = i;
                break;
            }
        }
        return hasEven;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}

package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        for (int i = row; i < data.length; i++) {
            if (column < data[row].length || data[i].length > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (data[row].length == 0) {
            row++;
        }
        int rsl = data[row][column++];
        if (column == data[row].length && row < data.length - 1) {
            column = 0;
            row++;
        }
        return rsl;
    }
}
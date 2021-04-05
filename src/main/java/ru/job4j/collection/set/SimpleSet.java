package ru.job4j.collection.set;

import ru.job4j.collection.SimpleArray;

import java.util.Iterator;

public class SimpleSet<T> implements Set<T> {

    private SimpleArray<T> set = new SimpleArray<>();

    @Override
    public boolean add(T value) {
        if (contains(value)) {
            return false;
        }
        set.add(value);
        return true;
    }

    @Override
    public boolean contains(T value) {
        int indexValue = indexByValue(value);
        if (indexValue != -1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        int indexValue = indexByValue(value);
        if (indexValue != -1) {
            set.remove(indexValue);
            return true;
        }
        return false;
    }

    private int indexByValue(T value) {
        for (int i = 0; i < set.getSize(); i++) {
            if (set.get(i) == value) {
                return i;
            } else if (set.get(i) != null && set.get(i).equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
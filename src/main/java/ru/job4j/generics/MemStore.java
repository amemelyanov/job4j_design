package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean rsl = false;
        T foundModel = findById(id);
        if (foundModel != null) {
            mem.set(mem.indexOf(foundModel), model);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean delete(String id) {
        boolean rsl = false;
        T foundModel = findById(id);
        if (foundModel != null) {
            mem.remove(foundModel);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public T findById(String id) {
        for (T t : mem) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public String get(int index) {
        return mem.get(index).getId();
    }
}
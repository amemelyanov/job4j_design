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
        int foundId = findIndexById(id);
        if (foundId != -1) {
            mem.set(foundId, model);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean delete(String id) {
        boolean rsl = false;
        int foundId = findIndexById(id);
        if (foundId != -1) {
            mem.remove(foundId);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public T findById(String id) {
        int foundId = findIndexById(id);
        if (foundId != -1) {
         return mem.get(foundId);
        }
        return null;
    }

    @Override
    public int findIndexById(String id) {
        int rsl = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                rsl = i;
            }
        }
        return rsl;
    }

    @Override
    public String get(int index) {
        return mem.get(index).getId();
    }
}
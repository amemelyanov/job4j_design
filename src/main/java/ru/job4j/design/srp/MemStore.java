package ru.job4j.design.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MemStore implements Store {

    private final List<Employee> employers = new ArrayList<>();

    public void add(Employee em) {
        employers.add(em);
    }

    @Override
    public List<Employee> findBy(Predicate<Employee> filter) {
        return employers.stream().filter(filter).collect(Collectors.toList());
    }
}
package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        /* тут должна быть реализация */
        while (source.hasNext()) {
            for (ArrayList<Integer> node : nodes) {
                if (source.hasNext()) {
                    node.add(source.next());
                } else {
                    break;
                }
            }
        }
    }
}
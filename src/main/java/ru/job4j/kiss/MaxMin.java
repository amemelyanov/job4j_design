package ru.job4j.kiss;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxMin {

    public <T> T loop(List<T> value, Comparator<T> comparator) {
        T rsl = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            if (comparator.compare(rsl, value.get(i)) < 0) {
                rsl = value.get(i);
            }
        }
        return rsl;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return loop(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return loop(value, comparator.reversed());
    }

   public static void main(String[] args) {
        Comparator<String> comparator = (o1, o2) -> o1.length() - o2.length();
        MaxMin maxMin = new MaxMin();
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("dddd");
        strings.add("bbb");
        strings.add("cc");
        System.out.println(maxMin.max(strings, comparator));
        System.out.println(maxMin.min(strings, comparator));
    }
}

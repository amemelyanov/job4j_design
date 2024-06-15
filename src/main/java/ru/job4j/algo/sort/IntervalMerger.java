package ru.job4j.algo.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class IntervalMerger {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> mergedIntervals = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] currentInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currentInterval[1]) {
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = intervals[i];
            }
        }
        mergedIntervals.add(currentInterval);
        return mergedIntervals.toArray(new int[0][]);
    }
}
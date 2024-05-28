package ru.job4j.algo;

import java.util.Arrays;

public class SmallestRangeFinder {
    /**
     * Добавьте поля класса здесь, если это необходимо
     */

    public static int[] findSmallestRange(int[] nums, int k) {
        /** Добавьте реализацию метода здесь
         Метод должен принимать массив nums и целочисленное значение k,
         и возвращать массив из двух целых чисел, представляющих наименьший диапазон
         с k различными элементами в массиве nums
         Если такой диапазон найти невозможно, вернуть null
         **/
        if (nums == null) {
            throw new IllegalArgumentException("Массив не может быть равен null");
        }
        if (nums.length < k) {
            throw new IllegalArgumentException("К не может быть больше длины массива");
        }
        if (nums.length == 1 && k == 1) {
            return new int[]{0, 0};
        }
        int end = 0;
        int range = 1;
        for (int i = 1; i < nums.length && range != k; i++) {
            if (nums[i - 1] != nums[i]) {
                range++;
                end = i;
            } else {
                range = 1;
            }
        }
        return range == k ? new int[]{end - k + 1, end} : null;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        int k = 0;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }
}
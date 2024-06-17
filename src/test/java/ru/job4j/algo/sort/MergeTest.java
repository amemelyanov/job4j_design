package ru.job4j.algo.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MergeTest {

    @Test
    void whenSortedThenOk() {
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        assertThat(Merge.mergesort(array)).containsExactly(-13, 2, 3, 4, 4, 6, 8, 10);
    }

    @Test
    void whenArrayLengthLessThanTwoThenOk() {
        int[] array = {0};
        assertThat(Merge.mergesort(array)).containsExactly(0);
    }

    @Test
    void whenArrayLengthEqualsTwoThenOk() {
        int[] array = {2, 1};
        assertThat(Merge.mergesort(array)).containsExactly(1, 2);
    }
}
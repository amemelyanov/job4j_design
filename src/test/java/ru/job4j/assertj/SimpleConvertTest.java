package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "four", "five");
        assertThat(list).hasSize(3)
                .contains("first")
                .containsExactly("first", "four", "five")
                .containsAnyOf("six", "four")
                .containsSequence("four", "five");
        assertThat(list).isNotNull()
                .allMatch(e -> e.startsWith("f"));
        assertThat(list).first().isEqualTo("first");
        assertThat(list).element(1).isNotNull().isEqualTo("four");
        assertThat(list).last().isEqualTo("five");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "four");
        assertThat(set).hasSize(4)
                .contains("second")
                .containsExactlyInAnyOrder("first", "second", "three", "four")
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("five");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(map).hasSize(5)
                .containsKeys("first", "second", "three", "four", "five")
                .containsValues(0, 1, 2, 3, 4)
                .doesNotContainKey("zero")
                .doesNotContainValue(5)
                .containsEntry("first", 0);
    }
}
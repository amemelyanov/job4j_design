package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");

    }

    @Test
    void whenNameArrayIsEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("array is empty");
    }

    @Test
    void whenDoesNotContainSymbol() {
        NameLoad nameLoad = new NameLoad();
        String name1 = "Ivan=Alex";
        String name2 = "Petr";
        assertThatThrownBy(() -> nameLoad.parse(name1, name2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain the symbol")
                .hasMessageContaining(name2);
    }

    @Test
    void whenDoesNotContainKey() {
        NameLoad nameLoad = new NameLoad();
        String name1 = "=Ivan";
        String name2 = "Petr=Oleg";
        assertThatThrownBy(() -> nameLoad.parse(name1, name2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain a key")
                .hasMessageContaining(name1);
    }

    @Test
    void whenDoesNotContainValue() {
        NameLoad nameLoad = new NameLoad();
        String name1 = "Ivan=Alex";
        String name2 = "Petr=";
        assertThatThrownBy(() -> nameLoad.parse(name1, name2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain a value")
                .hasMessageContaining(name2);
    }
}
package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void whenTypeTetrahedron() {
        Box box = new Box(4, 10);
        String type = box.whatsThis();
        assertThat(type)
                .isNotBlank()
                .isEqualTo("Tetrahedron");
    }

    @Test
    void whenTypeUNKNOWN() {
        Box box = new Box(4, -1);
        String type = box.whatsThis();
        assertThat(type)
                .isNotBlank()
                .isEqualTo("Unknown object");
    }

    @Test
    void whenValidNumbersOfVertex() {
        Box box = new Box(4, 4);
        int numbersOfVertices = box.getNumberOfVertices();
        assertThat(numbersOfVertices)
                .isPositive()
                .isGreaterThan(0)
                .isEqualTo(4);
    }

    @Test
    void whenNotValidNumbersOfVertex() {
        Box box = new Box(-5, 4);
        int numbersOfVertices = box.getNumberOfVertices();
        assertThat(numbersOfVertices)
                .isNegative()
                .isLessThan(0)
                .isEqualTo(-1);
    }

    @Test
    void whenDefaultNumbersOfVertex() {
        Box box = new Box(100, 4);
        int numbersOfVertices = box.getNumberOfVertices();
        assertThat(numbersOfVertices)
                .isNegative()
                .isLessThan(0)
                .isEqualTo(-1);
    }

    @Test
    void whenBoxExist() {
        Box box = new Box(4, 4);
        boolean exist = box.isExist();
        assertThat(exist)
                .isTrue();
    }

    @Test
    void whenBoxNotExist() {
        Box box = new Box(-5, 4);
        boolean exist = box.isExist();
        assertThat(exist)
                .isFalse();
    }

    @Test
    void areaWhenBoxSphere() {
        Box box = new Box(0, 2);
        double area = box.getArea();
        assertThat(area)
                .isEqualTo(50.26, withPrecision(0.006))
                .isCloseTo(50.26, Percentage.withPercentage(1))
                .isGreaterThan(50.26)
                .isLessThan(50.27);
    }

    @Test
    void areaWhenBoxCube() {
        Box box = new Box(8, 1);
        double area = box.getArea();
        assertThat(area)
                .isEqualTo(6, withPrecision(0.001))
                .isCloseTo(6, Percentage.withPercentage(1))
                .isGreaterThan(5.9)
                .isLessThan(6.1);
    }

    @Test
    void areaWhenBoxUNKNOWN() {
        Box box = new Box(-5, 4);
        double area = box.getArea();
        assertThat(area)
                .isEqualTo(0, withPrecision(0.001))
                .isCloseTo(0, Percentage.withPercentage(1))
                .isGreaterThan(-0.9)
                .isLessThan(0.1);
    }
}
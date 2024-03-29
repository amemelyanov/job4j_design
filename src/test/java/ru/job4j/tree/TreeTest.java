package ru.job4j.tree;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenAddDuplicate() {
        Tree<Integer> tree = new SimpleTree<>(1);
        assertTrue(tree.add(1, 2));
        assertFalse(tree.add(1, 2));
        assertTrue(tree.add(1, 3));
        assertTrue(tree.add(1, 4));
    }

    @Test
    public void whenBinaryTree() {
        Tree<Integer> tree = new SimpleTree<>(1);
        assertTrue(tree.add(1, 2));
        assertTrue(tree.add(1, 3));
        assertTrue(tree.add(2, 4));
        assertTrue(tree.isBinary());
    }

    @Test
    public void whenNotBinaryTree() {
        Tree<Integer> tree = new SimpleTree<>(1);
        assertTrue(tree.add(1, 2));
        assertTrue(tree.add(1, 3));
        assertTrue(tree.add(1, 4));
        assertTrue(tree.add(2, 5));
        assertFalse(tree.isBinary());
    }
}

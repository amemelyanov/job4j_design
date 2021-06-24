package ru.job4j.ood.isp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.ood.isp.menu.*;

public class MenuTest {
    private Node menu;

    @Before
    public void init() {
        this.menu = new Menu("0.", "Меню", new MenuAction("Выполнить Меню"));
        Node one = new Menu("1.", "Задача", new MenuAction("Выполняется задача 1."));
        Node oneOne = new Menu("1.1.", "Задача", new MenuAction("Выполняется задача 1.1."));
        Node oneOneOne = new Menu("1.1.1.", "Задача", new MenuAction("Выполняется задача 1.1.1."));
        Node oneOneTwo = new Menu("1.1.2.", "Задача", new MenuAction("Выполняется задача 1.1.2."));
        Node oneTwo = new Menu("1.2.", "Задача", new MenuAction("Выполняется задача 1.2."));
        menu.addChild(one);
        one.addChild(oneOne);
        one.addChild(oneTwo);
        oneOne.addChild(oneOneOne);
        oneOne.addChild(oneOneTwo);
    }

    @Test
    public void whenCorrectInputNumberOfMenuItem1Level() {
        Get get = new GetMenuItem();
        Action expected = new MenuAction("Выполняется задача 1.");
        Action rsl = get.getNode(menu, "1.").getAction();
        Assert.assertEquals(expected, rsl);
    }

    @Test
    public void whenCorrectInputNumberOfMenuItem2Level() {
        Get get = new GetMenuItem();
        Action expected = new MenuAction("Выполняется задача 1.1.");
        Action rsl = get.getNode(menu, "1.1.").getAction();
        Assert.assertEquals(expected, rsl);
    }

    @Test
    public void whenCorrectInputNumberOfMenuItem3Level() {
        Get get = new GetMenuItem();
        Action expected = new MenuAction("Выполняется задача 1.1.1.");
        Action rsl = get.getNode(menu, "1.1.1.").getAction();
        Assert.assertEquals(expected, rsl);
    }

    @Test(expected = NullPointerException.class)
    public void whenIncorrectInputNumberOfMenuItem() {
        Get get = new GetMenuItem();
        get.getNode(menu, "1.4.").getAction().execute();
    }

    @Test
    public void whenShowMenu() {
        Output output = new StubOutput();
        output.show(menu);
        String rsl = output.toString();
        String expected = " Задача 1. " + System.lineSeparator()
                        + "---- Задача 1.1. " + System.lineSeparator()
                        + "-------- Задача 1.1.1. " + System.lineSeparator()
                        + "-------- Задача 1.1.2. " + System.lineSeparator()
                        + "---- Задача 1.2. " + System.lineSeparator();
        Assert.assertEquals(expected, rsl);
    }
}

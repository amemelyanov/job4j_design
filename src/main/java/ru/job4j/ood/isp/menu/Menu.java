package ru.job4j.ood.isp.menu;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Node {
    private Action action;
    private final String name;
    private String number;
    private final List<Node> childrenMenuList = new ArrayList<>();

    public Menu(String number, String name, Action action) {
        this.action = action;
        this.name = name;
        this.number = number;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Action getAction() {
        return action;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public List<Node> getChildren() {
        return childrenMenuList;
    }

    @Override
    public void addChild(Node child) {
        childrenMenuList.add(child);
    }
}

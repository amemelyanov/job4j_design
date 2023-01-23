package ru.job4j.ood.isp.menu;

import java.util.List;

public interface Node {
    List<Node> getChildren();

    void addChild(Node child);

    String getNumber();

    String getName();

    Action getAction();
}

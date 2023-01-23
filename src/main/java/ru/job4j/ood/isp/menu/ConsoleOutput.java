package ru.job4j.ood.isp.menu;

public class ConsoleOutput implements Output {

    @Override
    public void show(Node root) {
        String prefix = "";
        for (Node child : root.getChildren()) {
            System.out.printf("%s %s %s %s", prefix, child.getName(), child.getNumber(),
                    System.lineSeparator());
            showChildren(child, prefix);
        }
    }

    private void showChildren(Node node, String prefix) {
        prefix += "----";
        for (Node child : node.getChildren()) {
            System.out.printf("%s %s %s %s", prefix, child.getName(), child.getNumber(),
                    System.lineSeparator());
            showChildren(child, prefix);
        }
    }
}

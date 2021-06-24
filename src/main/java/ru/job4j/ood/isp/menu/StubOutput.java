package ru.job4j.ood.isp.menu;

public class StubOutput implements Output {
    private final StringBuilder buffer = new StringBuilder();

    @Override
    public void show(Node root) {
        String prefix = "";
        for (Node child : root.getChildren()) {
            buffer.append(String.format("%s %s %s %s", prefix, child.getName(),
                    child.getNumber(), System.lineSeparator()));
            showChildren(child, prefix);
        }
    }

    private void showChildren(Node node, String prefix) {
        prefix += "----";
        for (Node child : node.getChildren()) {
            buffer.append(String.format("%s %s %s %s", prefix, child.getName(),
                    child.getNumber(), System.lineSeparator()));
            showChildren(child, prefix);
        }
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}

package ru.job4j.ood.isp.menu;


import java.util.List;

public class GetMenuItem implements Get {

    @Override
    public Node getNode(Node root, String number) {
        if (root.getNumber().equals(number)) {
            return root;
        } else {
            List<Node> children = root.getChildren();
            for (Node childNode : children) {
                Node result = getNode(childNode, number);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }
}

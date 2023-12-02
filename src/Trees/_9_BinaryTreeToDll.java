package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _9_BinaryTreeToDll {

    static class Node
    {
        Node left, right;
        int data;

        Node(int d)
        {
            data = d;
            left = right = null;
        }

    }

    Node bToDLL(Node root) {
        return traverse(root).get(0);
    }

    private List<Node> traverse(Node node) {
        if (node==null) return new ArrayList<>(Arrays.asList(null, null));
        if (node.left == null && node.right == null) {
            return new ArrayList<>(Arrays.asList(node, node));
        }

        List<Node> left = traverse(node.left);
        List<Node> right = traverse(node.right);
        if (left.get(1)!=null) {
            left.get(1).right = node;
        }
        node.left = left.get(1);
        if (right.get(0)!=null) {
            right.get(0).left = node;
        }
        node.right = right.get(0);
        return new ArrayList<>(Arrays.asList(left.get(0)!=null ? left.get(0) : node , right.get(1)!=null ? right.get(1) : node));
    }
}

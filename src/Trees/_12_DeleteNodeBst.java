package Trees;

import java.util.HashMap;
import java.util.Map;

public class _12_DeleteNodeBst {

    /* 1 Recursive
    * 2 Iterative */

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

    public static Node deleteNode(Node root, int X) {
        if (root==null) return null;

        if (X < root.data) {
            root.left = deleteNode(root.left, X);
        } else if (X > root.data) {
            root.right = deleteNode(root.right, X);
        } else {
            Node predecessor = findMax(root.left);
            if (predecessor==null) {
                return root.right;
            } else {
                root.data = predecessor.data;
                root.left = deleteNode(root.left, predecessor.data);
            }
        }
        return root;
    }

    public static Node findMax(Node root) {
        if (root==null) return null;
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static Map<String, Object> findNode(Node root, int X) {
        Map<String, Object> map = new HashMap<>();
        String node = "node";
        String parNode = "parentNode";
        /* for isLeftChild data = -1 means left child, else right child */
        String isLeftChild = "isLeftChild";
        Node par = null;
        while (root!=null && root.data!=X) {
            if (X < root.data) {
                root = root.left;
                map.put(isLeftChild, true);
            } else if (X > root.data) {
                root = root.right;
                map.put(isLeftChild, false);
            }
            par = root;
        }
        map.put(node, root);
        map.put(parNode, par);
        return map;
    }

}

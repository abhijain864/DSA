package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class _10_FlattenBinaryTreeToLinkedList {

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

    public static void main(String[] args) {
        String tree = "1 3 4 N N 2 N N 5";
        String[] treeArr = tree.split(" ");
        int j = 1;
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(Integer.parseInt(treeArr[0]));
        q.add(root);
        while (!q.isEmpty()) {
            Node pop = q.poll();
            if (j < treeArr.length) {
                if (!treeArr[j].equals("N")) {
                    pop.left = new Node(Integer.parseInt(treeArr[j]));
                    q.add(pop.left);
                } else {
                    pop.left = null;
                }
                j++;
            } else {
                break;
            }
            if (j < treeArr.length) {
                if (!treeArr[j].equals("N")) {
                    pop.right = new Node(Integer.parseInt(treeArr[j]));
                    q.add(pop.right);
                } else {
                    pop.left = null;
                }
                j++;
            } else {
                break;
            }
        }
        flatten(root);
        while (root!=null) {
            System.out.println(root.data);
            root = root.right;
        }
    }

    public static void flatten(Node root)
    {
        Node wrapper = new Node(-1);
        traverse(root, wrapper);
    }

    private static void traverse(Node root, Node tailWrapper) {
        if (root == null) return;

        if (tailWrapper.left != null) {
            tailWrapper.left.right = root;
        }
        tailWrapper.left = root;
        Node left = root.left;
        Node right = root.right;
        traverse(left, tailWrapper);
        traverse(right, tailWrapper);
        root.left = null;
    }


}

package Trees;

public class _4_MirrorTree {

    public static class Node {
        int data;
        Node left, right;
    }

    void mirror(Node node) {
        if (node==null || (node.left==null && node.right==null)) return;
        mirror(node.left);
        mirror(node.right);
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}

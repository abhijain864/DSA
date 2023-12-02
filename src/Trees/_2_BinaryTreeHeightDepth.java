package Trees;

public class _2_BinaryTreeHeightDepth {

    public static class Node {
        Node left, right;
        int data;
    }

    /* Height of binary tree */
    int height(Node node)
    {
        if (node==null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    /* Min depth of binary tree */
    int minDepth(Node node) {
        if (node.left == null && node.right == null) {
            return 1;
        } else if (node.left == null) {
            return minDepth(node.right) + 1;
        } else if (node.right == null) {
            return minDepth(node.left) + 1;
        } else {
            return Math.min(minDepth(node.left), minDepth(node.right)) + 1;
        }
    }

}

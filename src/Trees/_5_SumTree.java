package Trees;

public class _5_SumTree {

    public static class Node {
        int data;
        Node left, right;
    }

    public void toSumTree(Node root){
        traverse(root);
    }

    public int traverse(Node node) {
        if (node==null) return 0;
        int nodeData = node.data;
        int childSum = traverse(node.left) + traverse(node.right);
        node.data = childSum;
        return nodeData + childSum;
    }
}

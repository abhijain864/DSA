package Trees;

public class _8_DistanceBetween2Nodes {

    public static class Node {
        int data;
        Node left, right;
        Node(int item)    {
            data = item;
            left = right = null;
        }
    }

    int findDist(Node root, int a, int b) {
        Node minDis = new Node(0);
        traverse(root,a,b, minDis);
        return minDis.data;
    }

    Integer traverse(Node node, int a, int b, Node minDis) {
        if (node==null) return null;
        Integer left = traverse(node.left, a, b, minDis);
        Integer right = traverse(node.right, a, b, minDis);

        if (node.data == a || node.data == b) {
            if (left!=null) {
                minDis.data = left;
                return null;
            }
            else if (right!=null) {
                minDis.data = right;
                return null;
            }
            else return 1;
        } else {
            if (left!=null && right!=null) {
                minDis.data = left + right;
                return null;
            } else if (left!=null) {
                return left+1;
            } else if (right!=null) {
                return right+1;
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        root.left = left;
        root.right = right;
        new _8_DistanceBetween2Nodes().findDist(root, 2, 3);
    }

}

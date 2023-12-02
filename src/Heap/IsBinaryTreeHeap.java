package Heap;

import java.util.LinkedList;
import java.util.Queue;

public class IsBinaryTreeHeap {

    public static void main(String[] args) {

    }

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }

    }

    boolean isHeap(Node tree) {
        return isCompleteBT(tree) && maxValueProperty(tree);
    }

    private boolean maxValueProperty(Node root) {
        if (root == null) return true;
        boolean isRootSatisfying = (root.left == null || root.data > root.left.data) && (root.right == null || root.data > root.right.data);
        return isRootSatisfying && maxValueProperty(root.left) && maxValueProperty(root.right);
    }

    boolean isCompleteBT(Node root)
    {
        boolean nullElemFoundPreviously = false;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node popped = queue.poll();
            if (popped!=null) {
                if (nullElemFoundPreviously) {
                    return false;
                }
                queue.add(popped.left);
                queue.add(popped.right);
            } else {
                nullElemFoundPreviously = true;
            }
        }
        return true;
    }
}

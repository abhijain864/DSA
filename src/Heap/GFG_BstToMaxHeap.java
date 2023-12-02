package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GFG_BstToMaxHeap {

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

    /* The given BST is a complete binary tree */

    public static void inorder(Node root, List<Integer> list) {
        if (root==null) return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public static void treeFromPostorder(List<Integer> list, Node root) {
        if (root==null) return;
        root.data = list.get(0);
        list.remove(0);
        treeFromPostorder(list, root.right);
        treeFromPostorder(list, root.left);
    }

    public static void convertToMaxHeapUtil(Node root)
    {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        Collections.reverse(list);
        treeFromPostorder(list, root);
    }
}

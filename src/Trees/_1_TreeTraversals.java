package Trees;

import java.util.ArrayList;
import java.util.Stack;

public class _1_TreeTraversals {

    public static class Node {
        int data;
        Node left, right;
    }

    /* N  L  R */
    public static ArrayList<Integer> preorder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            Node popped = s.pop();
            ans.add(popped.data);
            if (popped.right!=null) {s.push(popped.right);}
            if (popped.left!=null) {s.push(popped.left);}
        }
        return ans;
    }

    /* L   N   R */
    public static ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Object> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            Object popped = s.pop();
            if (popped instanceof Integer) {
                ans.add((Integer) popped);
            } else if (popped instanceof Node) {
                Node poppedNode = (Node) popped;
                if (poppedNode.right!=null) {s.push(poppedNode.right);}
                s.push(poppedNode.data);
                if (poppedNode.left!=null) {s.push(poppedNode.left);}
            }
        }
        return ans;
    }

    /*  L  R  N  */
    public static ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Object> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            Object popped = s.pop();
            if (popped instanceof Integer) {
                ans.add((Integer) popped);
            } else if (popped instanceof Node) {
                Node poppedNode = (Node) popped;
                s.push(poppedNode.data);
                if (poppedNode.right!=null) {s.push(poppedNode.right);}
                if (poppedNode.left!=null) {s.push(poppedNode.left);}
            }
        }
        return ans;
    }
}

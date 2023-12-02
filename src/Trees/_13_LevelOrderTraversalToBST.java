package Trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class _13_LevelOrderTraversalToBST {

    /* We are given a level order traversal of a binary search tree, and we need to construct the binary search tree. */
    /* We will do 2 implementations, one recursive and one iterative. */

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

    static class GFG
    {
        static class Range {
            int left;
            int right;

            Node parent;

            Range(){}

            Range(int left, int right, Node parent) {
                this.left = left;
                this.right = right;
                this.parent = parent;
            }
        }

        //Function to construct the BST from its given level order traversal.
        public Node constructBST(int[] arr)
        {
            Node root = null;
            Queue<Range> q = new ArrayDeque<>();
            q.add(new Range(Integer.MIN_VALUE, Integer.MAX_VALUE, null));
            for (int j : arr) {
                while (!q.isEmpty() && (j < q.peek().left || j > q.peek().right)) {
                    q.poll();
                }
                Range range = q.poll();
                Node node = new Node(j);
                if (range != null) {
                    if (range.parent != null) {
                        if (j < range.parent.data) {
                            range.parent.left = node;
                        } else {
                            range.parent.right = node;
                        }
                    } else {
                        root = node;
                    }
                    q.add(new Range(range.left, j, node));
                    q.add(new Range(j, range.right, node));
                }
            }
            return root;
        }

        public static void main(String[] args) {
            Node root = new GFG().constructBST(new int[] {7,4,12,3,6,8,1,5,10});
            traverse(root);
        }

        static void traverse(Node root) {
            if (root==null) return;
            System.out.println(root.data);
            traverse(root.left);
            traverse(root.right);
        }
    }


}

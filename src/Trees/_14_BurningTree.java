package Trees;

import java.util.Map;

public class _14_BurningTree {

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

    static class ReturnVal {
        int depth;
        boolean isSpecial;

        ReturnVal(int d, boolean isSpecial) {
            this.depth = d;
            this.isSpecial = isSpecial;
        }
    }

    public static int minTime(Node root, int target)
    {
        ReturnVal global = new ReturnVal(1, false);
        traverse(root, target, global);
        return global.depth;
    }

    private static ReturnVal traverse(Node node, int target, ReturnVal global) {
        if (node == null) return new ReturnVal(0, false);
        if (node.left == null && node.right == null) {
            /* leaf node  */
            if (node.data == target) {
                return new ReturnVal(0, true);
            }
            else {
                return new ReturnVal(1, false);
            }
        } else if (node.right == null) {
            ReturnVal left = traverse(node.left, target, global);
            if (left.isSpecial) return new ReturnVal(left.depth + 1, true);
            else {
                return new ReturnVal(left.depth + 1, false);
            }
        } else if (node.left == null) {
            ReturnVal right = traverse(node.right, target, global);
            if (right.isSpecial) return new ReturnVal(right.depth + 1, true);
            else {
                return new ReturnVal(right.depth + 1, false);
            }
        } else {
            ReturnVal lef = traverse(node.left, target, global);
            ReturnVal right = traverse(node.right, target, global);
            if (lef.isSpecial) {
                if (lef.depth+1+right.depth>global.depth) {
                    global.depth = lef.depth+1+right.depth;
                }
                return new ReturnVal(lef.depth+1, true);
            } else if (right.isSpecial) {
                if (lef.depth+1+right.depth>global.depth) {
                    global.depth = lef.depth+1+right.depth;
                }
                return new ReturnVal(right.depth+1, true);
            } else {
                return new ReturnVal(Math.max(lef.depth, right.depth)+1, false);
            }
        }

    }

    public static int minTime2(Node root, int target) {
        ReturnVal global = new ReturnVal(0, false);
        traverse2(root, target, global);
        return 0;
    }

    private static ReturnVal traverse2(Node root, int target, ReturnVal global) {
        if (root==null) return new ReturnVal(0, false);
        ReturnVal left = traverse2(root, target, global);
        ReturnVal right = traverse2(root, target, global);
        if (root.data == target) {
            if (Math.max(left.depth, right.depth) > global.depth) {
                global.depth = Math.max(left.depth, right.depth);
            }
            return new ReturnVal(0, true);
        }
//        if (left.isSpecial || right.isSpecial) {
//
//        }
        return null;
    }


}

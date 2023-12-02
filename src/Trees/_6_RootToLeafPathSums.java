package Trees;

import java.util.ArrayList;
import java.util.List;

public class _6_RootToLeafPathSums {

    public static class Node {
        int data;
        Node left, right;
    }

    public static long treePathsSum(Node root)
    {
        List<Long> l = new ArrayList<>();
        traverse(root, "", l);
        long sum = 0;
        for (int i=0;i< l.size();i++) {
            sum+=l.get(i);
        }
        return sum;
    }

    public static void traverse(Node node, String str, List<Long> l) {
        if (node==null) return;

        String newStr = str + node.data;
        if (node.left == null && node.right == null) {
            l.add( Long.parseLong(newStr) );
            return;
        }
        traverse(node.left, newStr, l);
        traverse(node.right, newStr, l);
    }


}

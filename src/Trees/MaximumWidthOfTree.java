package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfTree {

    public static class Node {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    /* 2 3 4 S 9 10 11 12 S 3 4  */
    int getMaxWidth(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(new Node(-1));
        int width = 0, maxWidth = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.data == -1) {
                // level separator
                if (width > maxWidth) maxWidth = width;
                width = 0;
                if (!queue.isEmpty()) queue.add(new Node(-1));
            } else {
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
                width++;
            }
        }
        return maxWidth;
    }
}

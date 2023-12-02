package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteBinaryTree {

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

package Trees;

import java.util.*;
import java.util.stream.Collectors;

public class _3_DifferentViewsOfBinaryTree {

    public static class Node{
        Node left, right;
        int data;
    }

    /* 1 . Right view of binary tree */
    ArrayList<Integer> rightView(_2_BinaryTreeHeightDepth.Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        traverse(node, 1, ans);
        return ans;
    }

    private void traverse(_2_BinaryTreeHeightDepth.Node node, int level, ArrayList<Integer> list) {
        if (node==null) return;
        if (level > list.size()) list.add(node.data);
        traverse(node.right, level+1, list);
        traverse(node.left, level+1, list);
    }

    /* 2. Top view of binary tree */
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Item> map = new TreeMap<>();
        map.put(0, new Item(root.data, 0,0));
        traverse(root, 0, 0, map);
        for (Item item : map.values()) {
            ans.add(item.data);
        }
        return ans;
    }

    public static class Item {
        int data;
        int x;
        int y;

        Item(){}
        public Item(int data, int x, int y) {
            this.data = data;
            this.x = x;
            this.y = y;
        }
    }

    private static void traverse(Node node, int x, int y, Map<Integer, Item> map) {
        if (node==null) return;
        if (!map.containsKey(x)) {
            map.put(x, new Item(node.data, x, y));
        } else {
            Item item = map.get(x);
            if (y < item.y) {
                map.put(x, new Item(node.data, x,y));
            }
        }
        traverse(node.left, x-1, y+1, map);
        traverse(node.right, x+1, y+1, map);
    }

    /* 3. Left view of binary tree */
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        traverse2(root,0, ans);
        return ans;
    }

    public void traverse2(Node node, int level, ArrayList<Integer> ans) {
        if (node==null) return;
        if (level >= ans.size()) {
            ans.add(node.data);
        }
        traverse2(node.left, level+1, ans);
        traverse2(node.right, level+1, ans);
    }


}

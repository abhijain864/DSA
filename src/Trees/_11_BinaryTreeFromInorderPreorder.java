package Trees;

import java.util.HashMap;
import java.util.Map;

public class _11_BinaryTreeFromInorderPreorder {

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

    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(0, inorder.length-1, 0, preorder.length-1, inorder, preorder, map);
    }

    public static Node build(int i0, int i1, int p0, int p1, int inorder[], int preorder[], Map<Integer, Integer> map) {
        if (i0>i1 || p0>p1) return null;
        if (i0==i1 && p0==p1) {
            return new Node(inorder[i0]);
        }

        Node root = new Node(preorder[p0]);
        Integer idx = findIdx(inorder, i0, i1, preorder[p0]);
        if (idx!=null) {
            root.left = build(i0, idx-1, p0+1, p0+idx-i0, inorder, preorder, map);
            root.right = build(idx+1, i1, p0+idx-i0+1, p1, inorder, preorder, map);
        }
        return root;
    }

    private static Integer findIdx(int[] arr, int f, int l, int key) {
        for (int i=f;i<=l;i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return null;
    }


}

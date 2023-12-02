package Trees;

public class LeetCode236LCA {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traverse(root, p, q);
    }

    public TreeNode traverse (TreeNode node, TreeNode p, TreeNode q) {
        if (node==null) return null;
        if (node==p || node==q) return node;

        TreeNode left = traverse(node.left, p, q);
        TreeNode right = traverse(node.right, p, q);
        if (left!= null && right!=null) return node;
        else if (left!=null) {
            return left;
        } else if (right!=null) {
            return right;
        } else {
            return null;
        }
    }

}

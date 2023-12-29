public class KthSmallestElementBst {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int count = 0;

    TreeNode treeNode;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return treeNode.val;
    }

    // doing an inorder traversal
    public void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.left, k);
        count++;
        if (count == k) {
            treeNode = root;
        }
        traverse(root.right, k);
    }

    public static void main(String[] args) {

    }
}

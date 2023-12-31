public class PathSum {

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null) return false;
        return hasPathSumHelper(root, targetSum);
    }

    boolean hasPathSumHelper(TreeNode root, int targetSum) {
        if (root==null) {
            return targetSum==0;
        }
        if (root.left==null && root.right==null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }

}

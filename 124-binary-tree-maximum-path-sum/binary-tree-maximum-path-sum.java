
class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxSum;
    }

    public int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxPath(root.left));
        int right = Math.max(0, maxPath(root.right));

        maxSum = Math.max(maxSum, left + right + root.val);

        return root.val + Math.max(left, right);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {

        // Dono null hain
        if (left == null && right == null) {
            return true;
        }

        // Ek null hai, doosra nahi
        if (left == null || right == null) {
            return false;
        }

        // Values same honi chahiye
        if (left.val != right.val) {
            return false;
        }

        // Mirror positions compare karo
        return check(left.left, right.right)
            && check(left.right, right.left);
    }
}

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

    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);

        int rows = height;
        int cols = (1 << height) - 1;

        List<List<String>> result = new ArrayList<>();

        // Initialize matrix with empty strings
        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>();

            for (int j = 0; j < cols; j++) {
                row.add("");
            }

            result.add(row);
        }

        // Fill the tree
        fill(result, root, 0, 0, cols - 1);

        return result;
    }

    // Calculate height of tree
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(
            getHeight(root.left),
            getHeight(root.right)
        );
    }

    // Fill the matrix
    private void fill(
        List<List<String>> result,
        TreeNode node,
        int row,
        int left,
        int right
    ) {
        if (node == null) {
            return;
        }

        // Middle position
        int mid = left + (right - left) / 2;

        result.get(row).set(mid, String.valueOf(node.val));

        // Left subtree
        fill(
            result,
            node.left,
            row + 1,
            left,
            mid - 1
        );

        // Right subtree
        fill(
            result,
            node.right,
            row + 1,
            mid + 1,
            right
        );
    }
}
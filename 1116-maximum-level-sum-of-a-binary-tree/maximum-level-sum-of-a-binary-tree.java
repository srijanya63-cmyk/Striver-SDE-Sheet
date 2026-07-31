class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 1;
        int ans = 1;
        int maxSum = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int currSum = 0;

            while (size-- > 0) {
                TreeNode node = queue.poll();
                currSum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            if (currSum > maxSum) {
                maxSum = currSum;
                ans = level;
            }

            level++;
        }

        return ans;
    }
}
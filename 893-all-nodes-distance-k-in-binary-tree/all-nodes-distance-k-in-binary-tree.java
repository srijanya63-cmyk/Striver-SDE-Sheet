/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        markParents(root, parent);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            if (distance == k) {
                break;
            }

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                // Left child
                if (node.left != null && !visited.contains(node.left)) {
                    queue.offer(node.left);
                    visited.add(node.left);
                }

                // Right child
                if (node.right != null && !visited.contains(node.right)) {
                    queue.offer(node.right);
                    visited.add(node.right);
                }

                // Parent
                TreeNode par = parent.get(node);

                if (par != null && !visited.contains(par)) {
                    queue.offer(par);
                    visited.add(par);
                }
            }

            distance++;
        }

        List<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            ans.add(queue.poll().val);
        }

        return ans;
    }

    private void markParents(TreeNode root,
                             Map<TreeNode, TreeNode> parent) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node.left != null) {
                parent.put(node.left, node);
                queue.offer(node.left);
            }

            if (node.right != null) {
                parent.put(node.right, node);
                queue.offer(node.right);
            }
        }
    }
}

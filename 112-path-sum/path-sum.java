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
    private boolean helper(TreeNode root, int targetSum, int sum){
        if(root == null){
            return false;
        }

        sum += root.val;

        if(root.left == null && root.right == null && sum == targetSum){
            return true;
        }

        return helper(root.left,targetSum, sum) || helper(root.right,targetSum, sum);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        return helper(root, targetSum, sum);
    }
}
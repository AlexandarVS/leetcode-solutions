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
    private int maxDiameter = 0;
    private int longestPath(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = longestPath(root.left);
        int right = longestPath(root.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return 1 + Math.max(left, right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return maxDiameter;
    }
}
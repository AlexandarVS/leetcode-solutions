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
    private void helper(TreeNode root, List<Integer> leafs){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            leafs.add(root.val);
            return;
        }

        helper(root.left, leafs);
        helper(root.right, leafs);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        helper(root1, first);
        helper(root2, second);
        return first.equals(second);
    }
}
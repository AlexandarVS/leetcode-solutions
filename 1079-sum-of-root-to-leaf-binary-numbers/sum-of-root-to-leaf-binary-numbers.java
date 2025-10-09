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
    private void helper(TreeNode root, List<Integer> numbers, int number){
        if(root == null){
            return;
        }

        number = (number << 1) | root.val;
        
        if(root.left == null && root.right == null){
            numbers.add(number);
            number = 0;
            return;
        }

        helper(root.left,numbers,number);
        helper(root.right,numbers,number);
    }

    public int sumRootToLeaf(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result, 0);
        int sum = 0;
        for(int number : result){
            sum+= number;
        }
        return sum;
    }
}
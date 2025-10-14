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
    private void toSortedArray(TreeNode root, List<Integer> arr){
        if(root == null) return;

        toSortedArray(root.left,arr);
        arr.add(root.val);
        toSortedArray(root.right,arr);
    }
    public int getMinimumDifference(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        toSortedArray(root,arr);
        int minimumDifference = Integer.MAX_VALUE;
        for(int i = 1;i<arr.size();i++){
            if(Math.abs(arr.get(i) - arr.get(i - 1)) < minimumDifference){
                minimumDifference = Math.abs(arr.get(i) - arr.get(i - 1));
            }
        }
        return minimumDifference;
    }
}
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
    private void toSortedArr(TreeNode root, List<Integer> arr){
        if(root == null) return;

        toSortedArr(root.left, arr);
        arr.add(root.val);
        toSortedArr(root.right, arr);
    }
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        toSortedArr(root,arr);
        TreeNode result = new TreeNode(arr.get(0));
        TreeNode current = result;
        for (int i = 1; i < arr.size(); i++) {
            current.right = new TreeNode(arr.get(i));
            current = current.right;
        }
        return result;
    }
}
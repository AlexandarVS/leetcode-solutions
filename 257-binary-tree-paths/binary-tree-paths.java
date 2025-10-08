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
    private void helper(TreeNode root, List<String> result, String path){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            path+= Integer.toString(root.val);
            result.add(path);
            path = "";
        }

        path+= Integer.toString(root.val) + "->";
        helper(root.left, result, path);
        helper(root.right,result,path);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        String path = "";
        helper(root,result, path);
        return result;
    }
}
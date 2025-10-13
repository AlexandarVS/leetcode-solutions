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
    private void helper(TreeNode root, List<List<Integer>> values, int level){
        if(root == null) return;
        if(values.size() == level){
            values.add(new ArrayList<>());
        }
        values.get(level).add(root.val);
        helper(root.left, values, level + 1);
        helper(root.right, values, level + 1);
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> values = new ArrayList<>();
        helper(root, values, 0);

        List<Double> result = new ArrayList<>();
        for (List<Integer> innerList : values) {
            double sum = 0;
            for (int val : innerList) {
                sum += val;
            }
            result.add(sum / innerList.size());
        }
        return result;
    }
}
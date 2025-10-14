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
    private void toSortedArray(TreeNode root, List<Integer> elements){
        if(root == null){
            return;
        }

        toSortedArray(root.left,elements);
        elements.add(root.val);
        toSortedArray(root.right,elements);
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> sortedArr = new ArrayList<>();
        toSortedArray(root,sortedArr);
        int left = 0;
        int right = sortedArr.size() - 1;
        while(left < right){
            if(sortedArr.get(left) + sortedArr.get(right) == k){
                return true;
            }else if(sortedArr.get(left) + sortedArr.get(right) < k){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
}
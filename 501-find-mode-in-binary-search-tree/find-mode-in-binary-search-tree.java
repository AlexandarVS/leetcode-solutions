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
    private int iterator = 0;
    private int[] elements;

    private int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        elements[iterator++] = root.val;
        inorderTraversal(root.right);
    }

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        // build sorted array of values
        int total = countNodes(root);
        elements = new int[total];
        iterator = 0;
        inorderTraversal(root);

        // 1. find max frequency
        int maxCount = 1, currentCount = 1;
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] == elements[i - 1]) currentCount++;
            else currentCount = 1;
            if (currentCount > maxCount) maxCount = currentCount;
        }

        // 2. count how many numbers have that frequency
        int modeCount = 0;
        currentCount = 1;
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] == elements[i - 1]) currentCount++;
            else {
                if (currentCount == maxCount) modeCount++;
                currentCount = 1;
            }
        }
        if (currentCount == maxCount) modeCount++;

        // 3. collect the modes
        int[] modes = new int[modeCount];
        int index = 0;
        currentCount = 1;
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] == elements[i - 1]) currentCount++;
            else {
                if (currentCount == maxCount) modes[index++] = elements[i - 1];
                currentCount = 1;
            }
        }
        if (currentCount == maxCount) modes[index] = elements[elements.length - 1];

        return modes;
    }
}
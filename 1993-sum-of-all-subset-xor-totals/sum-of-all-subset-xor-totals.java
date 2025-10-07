class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int orAll = 0;

        for(int num : nums){
            orAll |= num;
        }

        return orAll * (1 << (n - 1));
    }
}
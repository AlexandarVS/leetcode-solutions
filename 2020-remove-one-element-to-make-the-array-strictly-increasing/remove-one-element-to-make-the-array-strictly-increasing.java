class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int countRemovableElements = 0;
        int iterator = 1;
        while(iterator != nums.length){
            if(nums[iterator - 1] >= nums[iterator]){
                countRemovableElements++;
                if (countRemovableElements > 1) return false;
                if (iterator > 1 && nums[iterator] <= nums[iterator - 2]) {
                    nums[iterator] = nums[iterator - 1];
                }
            }
            iterator++;
        }
        return countRemovableElements <= 1;
    }
}
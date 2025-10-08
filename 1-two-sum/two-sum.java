class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int[] original = nums.clone();
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                result[0] = nums[left];
                result[1] = nums[right];
                break;
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }

        int[] indices = new int[2];
        for(int i = 0; i < original.length; i++){
            if(original[i] == result[0] && indices[0] == 0){
                indices[0] = i;
            } else if(original[i] == result[1] && indices[1] == 0){
                indices[1] = i;
            }
        }
        return indices;
    }
}
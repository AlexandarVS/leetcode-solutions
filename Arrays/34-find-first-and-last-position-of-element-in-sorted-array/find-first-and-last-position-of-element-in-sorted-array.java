class Solution {
    public int binarySearch(int[] nums, int target, int left, int right){
        int middle = left + (right - left) / 2;
        if(left > right){
            return -1;
        }

        if(nums[middle] == target){
            return middle;
        }else if(nums[middle] < target){
            return binarySearch(nums,target, middle + 1,right);
        }else{
            return binarySearch(nums, target, left, middle - 1);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int occurance = binarySearch(nums,target, 0, nums.length - 1);

        if(occurance == -1){
            return new int[]{-1,-1};
        }

        int first = occurance;
        while (first > 0 && nums[first - 1] == target) {
            first--;
        }

        int second = occurance;
        while(second < nums.length - 1 && nums[second + 1] == target){
            second++;
        }

        return new int[]{first,second};
    }
}
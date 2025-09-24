class Solution {
public:
    int binarySearch(vector<int>& nums, int target, int left, int right){
        int middle = (left + right) / 2;

        if(left > right){
            return left;
        }

        if(nums[middle] == target){
            return middle;
        }else if(nums[middle] < target){
            return binarySearch(nums,target, middle + 1, right);
        }else{
            return binarySearch(nums,target, left, middle - 1);
        }
    }

    int searchInsert(vector<int>& nums, int target) {
        return binarySearch(nums,target, 0, nums.size() - 1);
    }
};
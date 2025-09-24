class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if(nums.empty()) return {-1,-1};

        int end = nums.size() - 1;
        int start = 0;

        while(start <= end){
            if(nums[start] == target && nums[end] == target){
                return {start, end};
            }

            if(nums[start] != target){
                start++;
            }

            if(nums[end] != target){
                end--;
            }
        }

        return {-1,-1};
    }
};
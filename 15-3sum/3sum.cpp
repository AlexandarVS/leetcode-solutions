class Solution {
public:
    int binarySearch(vector<int>& nums, int target, int left, int right){
        while(left <= right){
            int middle = left + (right - left) / 2;
            if(nums[middle] == target){
                return middle;
            }else if(nums[middle] < target){
                left = middle + 1;
            }else{
                right = middle - 1;
            }
        }
        return INT_MAX;
    }

    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        vector<vector<int>> result;
        for(int i = 0;i<nums.size();i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1;j<nums.size();j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int target = -(nums[i] + nums[j]);
                int k = binarySearch(nums,target, j + 1, nums.size() - 1);
                if(k != INT_MAX){
                    result.push_back({nums[i], nums[j], nums[k]});
                }
            }
        }
        return result;
    }
};
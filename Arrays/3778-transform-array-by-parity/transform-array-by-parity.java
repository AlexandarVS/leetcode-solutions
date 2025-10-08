class Solution {
    public int[] transformArray(int[] nums) {
        int countOdds = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] % 2 == 0){
                nums[i] = 0;
            }else{
                nums[i] = 1;
                countOdds++;
            }
        }

        int countEvens = nums.length - countOdds;
        for(int i = 0;i < nums.length;i++){
            if(i < countEvens){
                nums[i] = 0;
            }else{
                nums[i] = 1;
            }
        }

        return nums;
    }
}
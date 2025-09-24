class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        for(int i = digits.size() - 1;i >= 0;i--){
            if(digits[i] + 1 < 10){
                digits[i] += 1;
                return digits;
            }else{
                digits[i] = 0;

                if(i == 0){
                    digits.push_back(1);
                    swap(digits[0], digits[digits.size() - 1]);
                }
            }
        }

        return digits;
    }
};
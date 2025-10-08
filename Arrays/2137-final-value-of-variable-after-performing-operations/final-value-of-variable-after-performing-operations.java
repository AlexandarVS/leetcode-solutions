class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for(String operation : operations){
            switch(operation){
                case "++X" -> ++result;
                case "X++" -> result++;
                case "--X" -> --result;
                case "X--" -> result--;
            }
        }
        return result;
    }
}
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) return true;
            if (flowerbed[i] == 0) {
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                
                if (prev == 0 && next == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
    }
    return n == 0;
    }
}
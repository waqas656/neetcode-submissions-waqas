class Solution {
    public void sortColors(int[] nums) {
        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;

        // iterate array and count 0,1 and 2s
        for (int num : nums) {
            switch (num) {
                case 0: ++redCount; break;
                case 1: ++whiteCount; break;
                case 2: ++blueCount; break;
            }
        }

        // replace count values in original array
        for (int i = 0; i < nums.length; i++) {
            if (redCount != 0) {
                nums[i] = 0;
                --redCount;
            } else if (whiteCount != 0) {
                nums[i] = 1;
                --whiteCount;
            } else {
                nums[i] = 2;
                --blueCount;
            } 
        }

    }
}
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // scan nums and count number of zeros

        // if zeros count < 2: compute product of all numbers except 0s
        int product = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                ++zeroCount;
                continue; // skip the product for zeros
            }
            product *= num;
        }

        // if zeros count >= 2: set product as 0
        if (zeroCount >= 2) product = 0;

        // create result array
        int[] res = new int[nums.length];

        // if zeros count >= 2 or product is 0, simply add zeros in the whole result array
        if (product == 0) {
            for (int i = 0; i < nums.length; i++) {
                res[i] = 0;
            }
            return res;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) res[i] = product;
                else {
                    if (zeroCount == 1) {
                        res[i] = 0;
                    } else {
                        res[i] = product / nums[i];
                    }
                }
            }
        }

        return res;
    }
}  

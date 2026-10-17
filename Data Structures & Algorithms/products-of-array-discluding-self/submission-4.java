class Solution {
    public int[] productExceptSelf(int[] nums) {
        // calculate product from left side first and store in respective index in result array
        int[] res = new int[nums.length];

        int leftProd = 1;

        for (int i = 0; i < nums.length; i++) {
            res[i] = leftProd;
            leftProd *= nums[i];
        }

        // calculate product from right side and add product to current value at respective index in result array
        int rightProd = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = rightProd * res[i];
            rightProd *= nums[i];
            
        }
        
        return res;
    }
}  

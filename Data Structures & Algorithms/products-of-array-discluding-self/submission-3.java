class Solution {
    public int[] productExceptSelf(int[] nums) {
        int leftP = 1;
        int rightP = 1;

        // calculate left running product and store in result array
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = leftP;
            leftP *= nums[i];
        }

        // calculate right running product and multiply it with current element in result array and store there
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = rightP * res[i];
            rightP *= nums[i];
        }

        return res;
    }
}  

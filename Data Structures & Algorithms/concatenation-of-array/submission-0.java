class Solution {
    public int[] getConcatenation(int[] nums) {
        final int n = nums.length;

        // create with double the length of nums
        int[] ans = new int[n * 2];

        // loop over nums
        // store each element at ith and i + nth index
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        
        return ans;
    }
}
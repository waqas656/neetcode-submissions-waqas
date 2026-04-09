class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];

        // pick first number
        // start counting it
        // if it appears again increment the count
        // if another number appears, set decrease count
        // if count reaches 0, change the candidate
        int candidate = nums[0];
        int count = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == candidate) ++count;
            else {
                --count;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        
        return candidate;
    }
}
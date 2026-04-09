class Solution {
    public int removeElement(int[] nums, int val) {
        
        // [0,1,2,1,3,0,4,2]

        // use a pointer to mark the 'val' position
        // continue iterating until you find a 'non-val' element and overwrite it with 'val' element

        int nextWrite = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[nextWrite++] = nums[i];
            }
        }

        return nextWrite;

    }
}
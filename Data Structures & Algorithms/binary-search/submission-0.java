class Solution {
    public int search(int[] nums, int target) {

        // put start and end pointers, end at end of array, start at 0
        // repeat below steps while start is less than or equal to end
        // find mid between start and end using formula: start + (end - start) / 2 to avoid integer overflow
        // if element at mid is equal to target return its index
        // if element at mid is greater than target, set end to mid - 1
        // else if element at mid is less than target, set start to mid + 1
        // after the loop ends, return -1 as we were not able to find target during our search in while loop

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return -1;
    }
}

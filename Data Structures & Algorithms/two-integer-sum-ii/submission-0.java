class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0; // left pointer at start of asc order sorted array
        int right = numbers.length - 1; // right pointer on the largest element in asc order sorted array

        // invariant: No valid pair exists where both elements are outside the left...right window.
        while (left < right) {
            int sum = numbers[left] + numbers[right];

            // if sum is greater than target that means the element on right (as array is sorted in asc order) needs to be smaller so we move towards left of array
            if (sum > target) --right;
            else if (sum < target) ++left;
            else break;
        }
     
        return new int[] {left + 1, right + 1};
    }
}

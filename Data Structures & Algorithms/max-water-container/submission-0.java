class Solution {
    public int maxArea(int[] heights) {
        // keep a max variable at 0 initially
        int max = 0;

        // keep one pointer at starting and one pointer at ending wall and iterate
        int left = 0;
        int right = heights.length - 1;

        // invariant: max is updated when we find more water between left and right
        while (left < right) {
            // calculate the water they can hold between them and if that ie higher than max, update max with this amount of water
            int water = (right - left) * Math.min(heights[left], heights[right]);

            if (water > max) max = water;

            // move the pointer at smaller wall inwards as we have a chance of finding a higher wall and hence more water from that side
            if (heights[left] > heights[right]) --right;
            else ++left;
        }
        
        return max;
    }
}

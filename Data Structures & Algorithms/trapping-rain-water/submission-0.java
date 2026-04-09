class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;

        int trappedWater = 0;

        // iterate over array
        while (left <= right) {
            if (maxLeft <= maxRight) {
                // update maxLeft if applicable
                if (maxLeft < height[left]) maxLeft = height[left];
                int water = maxLeft - height[left];
                if (water >= 0) {
                    trappedWater += water;
                }
                ++left;
            } else {
                // update maxRight if applicable
                if (maxRight < height[right]) maxRight = height[right];
                int water = maxRight - height[right];
                if (water >= 0) {
                    trappedWater += water;
                }
                --right;
            }
        }

        return trappedWater;
    }
}

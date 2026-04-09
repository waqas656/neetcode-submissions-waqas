class Solution {
    public int trap(int[] height) {
        // keep track of maximum heightened wall on left and right side as these walls determine the amount of water a position can hold
        // we need a sum of all the amounts of water that all the positions/walls can hold
        // if there are less than or equal to 2 walls then return 0 as no water can be held between 2 walls only
        // if walls are more than or equal to 2, we look at left and right most walls
        // keep maxLeftHeightWall on index 0, maxRightHeightWall on index height.length - 1
        // invariant: maxLeftHeightWall and maxRightHeightWall are the tallest walls seen so far on left and right side respectively
        //iterate over array with pointer left on index 1 and right on index height.length - 2 until left becomes greater than right
        // if left wall is smaller than right wall:
        //      check if current left wall itself is the tallest left wall then update the tracker for maxLeftHeightWall
        //      calculate water than can trapped on that position by formula: maxLeftHeighWall - height[left] (as we have already seen than left wall is smallest between left and right walls so this wall decided how much water can sit on it)
        //      add it running sum of total trapped water
        //      increment left position to compare in next iteration
        // if right wall is smaller or equal: (we could add this equality check on first condition as well so it doesn't matter):
        //      check if current right wall itself is the tallest right wall then update the maxRightHeightWall
        //      calculate water than can be trapped on this current position by: maxRightHeightWall - height[right]
        //      add it to accumulating sum of total trapped water
        //      decrement right pointer for comparison in next iteration
        // return totalTrappedWater
        if (height.length <= 2) return 0;

        int maxHeightOnLeft = 0;
        int maxHeightOnRight = 0;

        int left = 0; // as no water can be trapped on left most wall, so we start from one wall right to the left most
        int right = height.length - 1; // as no water can be trapped on right most wall so we start from one wall left to the right most

        int trappedWater = 0;

        while (left <= right) {
            if (height[left] < height[right]) {
                if (height[left] > maxHeightOnLeft) maxHeightOnLeft = height[left]; // if current wall is the tallest
                int water = maxHeightOnLeft - height[left];
                trappedWater += water;
                ++left;
            } else {
                if (height[right] > maxHeightOnRight) maxHeightOnRight = height[right]; // if current wall is the tallest
                int water = maxHeightOnRight - height[right];
                trappedWater += water;
                --right;
            }
        }

        return trappedWater;
    }
}

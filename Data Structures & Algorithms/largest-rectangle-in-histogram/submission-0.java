class Solution {
    public int largestRectangleArea(int[] heights) { 
        // initialize a max tracker with 0 as 0 is minimum possible height in this array 
        // iterate heights one by one from 0 index till n - 1 where is length of heights array 
        // pick a height i-e any index height 
        // first loop from that index towards left until you encounter a height that is smaller than current or index reaches -1 
        // then loop from that index towards right until you encounter a height that is smaller than current or index reaches heights.length
        // during this left and right traversal, count the number of indexes/bars visited are less equal or greater than current height and increment it by 1 to include the current bar as well, then multiply it with current height to get area of rectangle 
        // compare this area with max tracker to update if possible // at the end after traversing all heights, return max 
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];

            // iterate left
            int leftCount = 0;
            int li = i - 1;
            while (li >= 0 && heights[li] >= h) {
                ++leftCount;
                --li;
            }


            // iterate right
            int rightCount = 0;
            int ri = i + 1;
            while (ri < heights.length && heights[ri] >= h) {
                ++rightCount;
                ++ri;
            }

            int area = (leftCount + rightCount + 1) * h;
            
            // update max
            max = Math.max(max, area);
        }

        return max;
    }
}

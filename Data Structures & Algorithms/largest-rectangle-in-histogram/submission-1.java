class Solution {
    public int largestRectangleArea(int[] heights) { 
        // loop from index 0 to n - 1 
        // for every element: 
        // while stack is not empty, check if number at peek (find using index stored in stack) is greater or equal to current element, pop it, calculate the width by formula: next small element (i) - previous small element (stack.isEmpty() ? -1 : stack.peek()) - 1 then use formula for area = h x w and compare it with max starting at 0 to update max if possible 
        // after while loop ends, push current index to stack 
        // at the end of main loop if stack is not empty, loop until stack is not empty and pop and calculate their width by n - (if stack.isempty then -1 else stack.peek) - 1 then find area by area = hxw and update max if possible
        // return max
        
        int max = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {

            while (!stack.isEmpty() && (heights[stack.peek()] > heights[i])) {
                int h = heights[stack.pop()];
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                int width = nse - pse - 1;
                int area = width * h;
                max = Math.max(max, area);
            }

            stack.push(i);
        }

        // clean up any remaining elements inside stack
        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int nse = heights.length;
            int pse = stack.isEmpty() ? -1 : stack.peek();

            int width = nse - pse - 1;
            
            int area = width * h;
            max = Math.max(max, area);
        }

        return max;
    }
}

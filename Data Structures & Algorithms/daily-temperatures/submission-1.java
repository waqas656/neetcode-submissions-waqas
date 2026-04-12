class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // At any point during the scan, the stack contains the indices of days whose temperatures are not resolved yet meaning a higher temperature is not found yet
        // store index of element in stack
        // for next element, check peak of stack and see if it resolves current element i-e it is greater than peek element
        // if it is greater than peek, calculate distance from peak by i - element at peek index and store in result array
        // else store current element in stack
        // at the end, empty the stack by storing 0 at all remaining indexes
        
        int[] res = new int[temperatures.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int distance = i - stack.peek();
                res[stack.peek()] = distance;
                stack.pop();
            }

            stack.push(i);
        }

        // remaining indexes in res already have zero so no need to clear the stack to set 0 for every element

        return res;
    }
}

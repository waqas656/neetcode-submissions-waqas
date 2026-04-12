class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // store index of element in stack
        // for next element, check peak of stack and see if it resolves current element i-e it is greater than peek element
        // if it is greater than peek, calculate distance from peak by j - peek and store in result array
        // else store current element in stack
        
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

        while (!stack.isEmpty()) {
            res[stack.peek()] = 0;
            stack.pop();
        }

        return res;
    }
}

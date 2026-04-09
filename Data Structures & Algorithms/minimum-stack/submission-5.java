class MinStack {
    // create a dq stack object for storing min with every push
    // at any point the top/front of the stack will contain the minimum after that push
    // use main stack to store all the numbers in it
    Deque<Integer> minStack;
    Deque<Integer> mainStack;

    public MinStack() {
        minStack = new ArrayDeque<>();
        mainStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        // if main stack is empty push val onto it
        // else:
        // compare val with top of min stack, and update min if possible, push min to minstack
        // push to main stack
        mainStack.push(val);

        if (minStack.isEmpty()) minStack.push(val);
        else {
            int min = Math.min(minStack.peek(), val);
            minStack.push(min);
        }
    }
    
    public void pop() {
        // remove top element from both min and main stack
        mainStack.pop();
        minStack.pop();
    }
    
    public int top() {
        // return the top element from the main stack
        return mainStack.peek();
    }
    
    public int getMin() {
        // return the top element from the min stack
        return minStack.peek();
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        // invariant: at any point during scan, stack will contain only the operands to apply the operation on

        // check if token is digit or not
        // when token is digit, convert character to number and use stack to store tokens 
        // when you encounter an operator among -,+,*,/ start popping out token
        // the first one you popout, consider it as last
        // the second one you popout, consider it as second last
        // then apply the operation as per operator
        // push the result back to stack
        // after the loop ends, return the last element in stack

        Deque<Integer> stack = new ArrayDeque<>();

        for (String t : tokens) {
            int first;
            int second;
            switch (t) {
                case "+":
                second = stack.pop();
                first = stack.pop();
                stack.push(second + first);
                break;

                case "*":
                second = stack.pop();
                first = stack.pop();
                stack.push(second * first);
                break;

                case "-":
                second = stack.pop();
                first = stack.pop();
                stack.push(first - second);
                break;

                case "/":
                second = stack.pop();
                first = stack.pop();
                stack.push(first / second);
                break;

                default: // it is a number
                    stack.push(Integer.parseInt(t));
            }
        }
        
        return stack.pop();
    }
}

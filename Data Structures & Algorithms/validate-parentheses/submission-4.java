class Solution {
    public boolean isValid(String s) {
        // if string is empty then return true
        // if string has only one character then return false
        // there are only 3 types of brackets '{}', '()' and '[]'
        // if bracket is not closing we push it to stack
        // else if stack is not empty then :
        // we determine whether bracket is among '}', ')' or ')' and then compare by checking last element in stack
        // if bracket is other than this, return false
        // else remove that bracket from stack
        // after loop ends and if stack is not empty return false else true

        Deque<Character> dq = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!isOpening(c) && dq.isEmpty()) return false;

            else if (!isOpening(c) && !dq.isEmpty()) {
                if (dq.peek() != partnerOf(c)) return false;
                dq.pop();
            } 
            else dq.push(c);
        }

        return dq.isEmpty();
    }

    private boolean isOpening(char c) {
        if (c == '}' || c == ']' || c == ')') return false;
        else return true;
    }

    private char partnerOf(char c) {
        switch (c) {
                case '}': return '{';
                case ']': return '[';
                case ')': return '(';
                default:
                return 'a';
        }
    }
}

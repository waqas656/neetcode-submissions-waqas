class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // use result array of size n - k + 1
        
        // use left and right pointers to traverse array

        // move right from 0 index until nums.length - 1

        // use a deque to store elements in decreasing order

        // store index of right index element into deque

        // if element at right index is larger than the one at back of deque, then keep on removing back element until you find an equal or greater element at last

        // before incrementing left pointer, check if it is at the front of deque by comparing left with dq.peek(), if it is: then remove front

        // if right - left + 1 window equals k, then store deque.peek() into result array

        // increment right

        int n = nums.length;
        int[] res = new int[n - k + 1];
        int i = 0; // iterator for result array
        int left = 0;
        int right = 0;

        Deque<Integer> dq = new ArrayDeque<>();

        while (right < n) {
            
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[right]) {
                dq.pollLast();
            }

            dq.addLast(right);

            int winSize = right - left + 1;
            if (winSize >= k) {
                res[i++] = nums[dq.peekFirst()];
                
                if (dq.peekFirst() == left) {
                    dq.pollFirst();
                }

                ++left;
            }

            ++right;
        }

        return res;
    }
}

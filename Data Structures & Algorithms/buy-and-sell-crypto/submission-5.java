class Solution {
    public int maxProfit(int[] prices) {
        // if array has 1 length, return 0
        // keep min tracker at first index of array, and a maxProfit variable, at value 0, to track maxProfit seen so far
        // invariant: min is the smallest element seen so far, maxProfit is the maximum profit seen so far among visited elements
        // iterate array from 2nd element
        // if element is smaller than min, update min
        // calculate profit by subtracting min from current value
        // if new profit is greater than existing one, update maxProfit
        // return maxprofit
        if (prices.length <= 1) return 0;

        int maxProfit = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];

            maxProfit = Math.max(maxProfit, prices[i] - min);
        }

        return maxProfit;
    }
}

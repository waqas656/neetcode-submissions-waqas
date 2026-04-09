class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;

        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < smallest) {
                smallest = prices[i];

                // reset largest
                largest = smallest;
                continue;
            } if (prices[i] > largest) {
                largest = prices[i];
                if ((largest - smallest) > profit) profit = largest - smallest;
            }
        }

        if (largest == smallest && profit == 0) return 0;
        
        return profit;
    }
}

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // find max pile → that's our upper bound for k
// start = 1, end = max(piles)
// while start <= end:
//     mid = start + (end - start) / 2
//     if canFinish(piles, mid, h):
//         end = mid - 1     (mid works, try smaller)
//     else:
//         start = mid + 1   (mid too slow, need faster)
// return start

// helper canFinish(piles, k, h):
//     totalHours = 0
//     for each pile p in piles:
//         totalHours += ceil(p / k)  using (p + k - 1) / k
//     return totalHours <= h

        int start = 1;
        int end = 1_000_000_000;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (canFinish(piles, mid, h)) end = mid - 1;
            else start = mid + 1;
        }
        
        return start;
    }

    boolean canFinish(int[] piles, int k, int h) {
        int totalHours = 0;

        for (int p : piles) {
            totalHours += (p + k - 1) / k;
        }

        return totalHours <= h;
    }
}

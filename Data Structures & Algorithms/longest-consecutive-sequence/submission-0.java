class Solution {
    public int longestConsecutive(int[] nums) {
    if (nums.length < 2) return nums.length;

    Set<Integer> set = new HashSet<>();

    // STORE all numbers in set for fast lookup
    for (int num : nums) {
        set.add(num);
    }

    // [2,20,4,10,3,4,5]
    int max = Integer.MIN_VALUE; // for tracking max sequence
    // check sequence
    for (int num : nums) {
        // invariant: a number num is a part of sequence if num - 1 exists
        if (!set.contains(num - 1)) {
            int count = 1; // for tracking current sequence length
            // if previous number doesn't exist, it means it is a start of a new sequence
            while (set.contains(num + 1)) {
                ++count; // increment current sequence length
                num += 1; // increment the number
            }

            // compare the current sequence with current max
            max = Math.max(max, count);
        }
    }
    
    return max;
}



}

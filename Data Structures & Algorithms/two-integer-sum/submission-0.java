class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // iterate and store elements in a hashmap
        Map<Integer, Integer> elMap = new HashMap<>();

        // with each element, subtract the element from the target to see if the other number is in hashmap
        for (int i = 0; i < nums.length; i++) {
            int q = target - nums[i];
            if (elMap.containsKey(q)) {
                return new int[] {elMap.get(q), i};
            }

            elMap.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}

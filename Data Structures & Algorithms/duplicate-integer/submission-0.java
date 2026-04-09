class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Boolean> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(nums[i])) {
                return true;
            } else {
                numMap.put(nums[i], true);
            }
        }

        return false;
    }
}

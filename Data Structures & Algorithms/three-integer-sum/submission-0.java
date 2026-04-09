class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // [-1,0,1,2,-1,-4] -> [-4, -1, -1, 0, 1, 2]
        List<List<Integer>> tList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            int target = nums[i] * -1;

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[left]);
                    ls.add(nums[right]);
                    ls.add(nums[i]);
                    tList.add(ls);

                    ++left;
                    --right;

                    while (left < right && nums[left] == nums[left - 1]) ++left;
                    while (left < right && nums[right] == nums[right + 1]) --right;
                } else if (sum > target) {
                    --right;
                } else {
                    ++left;
                }
            }
        }

        return tList;
}
}

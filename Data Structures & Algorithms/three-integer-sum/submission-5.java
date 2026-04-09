class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> tList = new ArrayList<>();
        // sort array
        Arrays.sort(nums);

        // iterate and pick one element from array
        for (int i = 0; i < nums.length - 1; i++) {
            // iterate from i + 1 till end of array
            int left = i + 1;
            int right = nums.length - 1;

            // avoid duplicates, by skipping the iteration of current element is equal to previous element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            while (left < right) {
                // calculate sum of outer i and inner left and right elements
                int sum = nums[i] + nums[left] + nums[right];

                // from here the problem is just like sorted 2 sum
                if (sum > 0) {
                    --right;
                } else if (sum < 0) {
                    ++left;
                } else {
                    // when equal to target (0), we store it in a list
                    tList.add(new ArrayList<>(List.of(nums[i], nums[left], nums[right])));

                    // increment both pointers to search for more triplets
                    ++left;
                    --right;

                    // we need to skip inner right elements which are same as well, as outer similar elements from left will form identical triplets with them
                    while (left < right && nums[right] == nums[right + 1]) --right;
                    //while (nums[left] == nums[left - 1]) ++left;
                }
            }
        }
        
        return tList;
    }
}

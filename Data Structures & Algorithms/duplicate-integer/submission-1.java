class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        // we will loop through array
        // store each element in a set
        // if a num is already present in set then return true
        Set<Integer> checker = new HashSet<>();

        for (int el : nums) {
            if (checker.contains(el)) return true;

            checker.add(el);
        }
        
        // if no element is detected to be duplicate
        return false;
    }
}
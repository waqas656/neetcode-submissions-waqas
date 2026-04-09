class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // create frequency map of all elements in array
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.merge(num, 1, Integer::sum);
        }

        // create array of lists equal to nums.length + 1 size
        List<Integer>[] arrList = new List[nums.length + 1];

        // we iterate map and for each key, value pair:
        // fill the above array using counts (value) from array as index 
        // and key will be added in the list at that index
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (arrList[value] == null) {
                arrList[value] = new ArrayList<>();
            }
            arrList[value].add(key);
        }

        // iterate this list from end of array and pick elements from 
        // these lists and add to a result array of size k, where we count
        // the elements we get from these lists until it reaches k
        // invariant: index of element describes the frequency of that element in nums array
        int[] res = new int[k];
        int count = 0;
        for (int i = nums.length; i >= 0; i--) {
            if (arrList[i] == null) continue;
            for (int j = 0; j < arrList[i].size(); j++) {
                res[count++] = arrList[i].get(j);
                if (count == k) return res;
            }
        }

        return new int[] {nums[0]};
    }
}

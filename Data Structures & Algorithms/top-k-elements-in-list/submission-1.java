class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // store each number's frequency in a map with number as key and freq as value
        Map<Integer, Integer> m = new HashMap<>();
        for (int n : nums) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }

        // loop over map and store elements in an array on the index = value of map entry so that in that list we have each element at its frequency index
        List<List<Integer>> list = new ArrayList<>();

        // initialize list
        for (int i = 0; i <= nums.length; i++) {
            list.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            int num = entry.getKey();
            int idx = entry.getValue();

            list.get(idx).add(num);
        }


        // loop over list from end (highest index/frequency) and store in result array until it equals k
        int[] res = new int[k];

        int idx = 0;
        for (int i = nums.length; i > 0; i--) {
            List<Integer> ls = list.get(i);
            for (Integer in : ls) {
                res[idx++] = in;
                if (idx == k) return res;
            }
        }

        return res;
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> strMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chArr = strs[i].toCharArray();
            Arrays.sort(chArr);

            String key = new String(chArr);

            List<String> strsList;

            // check if keyExists
            if (strMap.containsKey(key)) {
                // get the hashset from value
                strsList = strMap.get(key);
            } else {
                strsList = new ArrayList<>();
            }

            strsList.add(strs[i]);
            strMap.put(key, strsList);
        }

        return new ArrayList<>(strMap.values());       
    }
}
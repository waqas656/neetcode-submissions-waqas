class Solution {
    public boolean isAnagram(String s, String t) {

        // if length of 2 strings is diff then they can't be equal
        if (s.length() != t.length()) return false;

        Map<Character, Integer> countMap = new HashMap<>();

        // iterate first array and store each character and its count in HashMap
        for (char ch : s.toCharArray()) {
            countMap.merge(ch, 1, Integer::sum);
        }

        // loop through 2nd array and do look up in hashmap
        // if not found, return false immediately
        // if found, decrement the counter
        for (char ch : t.toCharArray()) {
            if (countMap.containsKey(ch)) {
                int count = countMap.get(ch);
                --count;
                countMap.put(ch, count);
            } else return false;
        }
        
        // compare if all keys have values equal to zero
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() != 0) return false;
        }

        return true;
    }
}

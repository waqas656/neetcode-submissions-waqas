class Solution {
    public int lengthOfLongestSubstring(String s) {
    // keep a max variable to get the highest/max sequence length
// iterate using 2 pointers left and right, both initially at 0
// store each character in Hashmap along with its index
// invariant: characters between left and right - 1 are always unique
// for each character:
//      check if it exists in hashmap, means it is a duplicate:
//          update max by checking if HashMap's size is greater than max
//          get its index from map
//          loop from left pointer until that index (inclusive) and remove each character from map
//      add the character to HashMap
//      move right forward
// after loop, check the hashmap size again to compare last ongoing sequence
// return max
    
    
    int left = 0;
    int right = 0;
    Map<Character, Integer> uMap = new HashMap<>();
    int max = 0;

    while (right < s.length()) {
        char ch = s.charAt(right);
        if (uMap.containsKey(ch)) {
            if (uMap.size() > max) max = uMap.size();
            int end = uMap.get(ch);
            while (left <= end) {
                uMap.remove(s.charAt(left));
                ++left;
            }
        } 
        
        uMap.put(ch, right);
        ++right;
    }

     if (!uMap.isEmpty()) {
        if (uMap.size() > max) max = uMap.size();
     }
     return max;
    }

    
}

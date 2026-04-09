class Solution {
    public int lengthOfLongestSubstring(String s) {

        // create a HashMap to store each character and their index in the string
        // store first character in HashMap
        // keep a max variable to track max length seen so far
        // keep left pointer at 0 and right pointer at 1
        // invariant: at every iteration, characters between left and right - 1 are always unique
        // iterate until right reaches s.length
        // if element at right exists in HashMap, start loop from left till index of duplicate elements from Hashmap (inclusive)
        //          delete elements from HashMap
        //          move left index equal to duplicate index + 1 index
        //          if current right - left length is greater than max, update max
        //          
        // if element at right does not exist in HashMap:
        //          add it to hashmap
        // after loop, compare length of any ongoing right - left with max and update if applicable
        // return max





    // move left and right characters
    // start both at 0 index
    // move right pointer only until a duplicate occurs
    // store characters in hashmap until a duplicate comes
    // note the length of current string with right - left + 1
    // move left to the index + 1 of the duplicate character
    // store it in max variable
    // clear Map
    
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

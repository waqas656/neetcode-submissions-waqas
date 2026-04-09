class Solution {
    public int characterReplacement(String s, int k) {
        // start with left and right pointers at 0
        // keep each character's count within the window in HashMap
        // keep maxWindow variable for the longest window we have seen so far
        // 
        // invariant: characters between right and left form the window size
        // iterate array until right reaches s.length:
        //      add/update character's count in hashmap
        //      iterate through hashmap to get the most frequent element
        //      get window size by formula: right - left
        //      if window size - most frequent element > k:
        //          decrement count of character at left in hashmap
        //          increment left pointer
        //      else:
        //          compare maxWindow with current window using right - left + 1 and update maxWindow if applicable
        //          
        //      increment right pointer
        //
        // return maxWindow

        int left = 0;
        int right = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int maxWindow = 0;
        int maxCharCount = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            freqMap.merge(ch, 1, Integer::sum); // build frequency map

            maxCharCount = Math.max(maxCharCount, freqMap.get(ch));

            int windowSize = right - left + 1;

            boolean isValidWindow = (windowSize - maxCharCount) <= k;

            if (isValidWindow) {
                maxWindow = Math.max(maxWindow, windowSize);
            } else {
                int lChar = freqMap.get(s.charAt(left));
                freqMap.put(s.charAt(left), --lChar);
                ++left;
            }

            ++right;
        }

        return maxWindow;
    }

    private char getMostFrequentCharacter(Map<Character, Integer> fMap) {
        int maxValue = 0;
        char maxKey = 'a';
        for (Map.Entry<Character, Integer> entry : fMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value > maxValue) {
                maxValue = value;
                maxKey = key;
            }
        }

        return maxKey;
    }
}

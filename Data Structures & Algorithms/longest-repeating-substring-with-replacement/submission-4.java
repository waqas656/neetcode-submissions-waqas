class Solution {
    public int characterReplacement(String s, int k) {
        // start from left and expand to include characters of a string to form a substring
        // in that substring, we need to check which character has highest frequency/occurence
        // then subtract the highest frequency character from the substring length
        // if the resultant value is less than or equal to k, keep expanding the string by incrementing right pointer
        // if value is greater than k, then remove the first character from the substring by moving left by 1 character
        // during this process note the maximum window length so far, till the end of string is reached
        // return maximum window length

        int left = 0;
        int right = 0;
        int maxWindow = 0;
        int maxFreq = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        while (right < s.length()) {
            char ch = s.charAt(right);

            freqMap.merge(ch, 1, Integer::sum);

            int windowSize = (right - left) + 1;

            // we keep highest occuring element in hashmap, then for each element 
            // we simply add and check that element frequency, if it is greater than max, 
            // we update max, instead of looping through hashmap every time
            maxFreq = Math.max(freqMap.get(ch), maxFreq);

            boolean validWindow = (windowSize - maxFreq) <= k;

            if (validWindow) {
                maxWindow = Math.max(maxWindow, windowSize);
            } else {
                // first remove the character that we are going to remove from current window from left
                freqMap.put(s.charAt(left), freqMap.get(s.charAt(left)) - 1);

                // then increment left
                ++left;
            }

            ++right;
        }
        
        return maxWindow;
    }
}

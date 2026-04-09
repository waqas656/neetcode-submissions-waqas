class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // create 2 frequency arrays
        // in first freq array, store frequencies of s1
        // create variable matches = 26 and while storing frequencies, decrement matches by 1, each time incrementing s1 frequency if existing value is 0 for that character
        // keep 2 pointers left and right at first index
        // iterate until matches == 26 or right < s2.length()
        // for each character, increment its frequency in s2 and before incrementing check if that frequency will match the respective frequency in s1 and update matches variable
        // after window size reaches s1.length(), each new iteration will remove 1 element from start and add new element at end so check if adding or removing frequency will match the corresponding frequency value in s1 and update matches vairable
        // after coming out of loop if matches == 26, return true else false

        if (s1.length() > s2.length()) return false;

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        int matches = 26;

        for (char ch : s1.toCharArray()) {
            if (s1Freq[ch - 'a'] == 0) {
                --matches;
            }
            ++s1Freq[ch - 'a'];
        }

        int left = 0, right = 0;

        while (right < s2.length()) {
            char leftCh = s2.charAt(left);
            char rightCh = s2.charAt(right);
            
            if (right > s1.length() - 1) {
                if (s2Freq[leftCh - 'a'] - 1 == s1Freq[leftCh - 'a']) {
                    ++matches;
                } else if (s2Freq[leftCh - 'a'] == s1Freq[leftCh - 'a']) {
                    --matches;
                }

                --s2Freq[leftCh - 'a'];
                ++left;
            }

            if (s2Freq[rightCh - 'a'] + 1 == s1Freq[rightCh - 'a']) {
                ++matches;
            } else if (s2Freq[rightCh - 'a'] == s1Freq[rightCh - 'a']) {
                --matches;
            }

            if (matches == 26) return true;

            ++s2Freq[rightCh - 'a'];
            ++right;
        }

        return matches == 26;
    }
}

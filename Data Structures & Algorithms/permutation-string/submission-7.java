class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        int matches = 26;

        for (char ch : s1.toCharArray()) {
            if (s1Freq[ch - 'a'] == 0) --matches;
            ++s1Freq[ch - 'a'];
        }

        int left = 0;
        int right = 0;

        while (right < s2.length()) {

            if (right > s1.length() - 1) {
                if (s2Freq[s2.charAt(left) - 'a'] - 1 == s1Freq[s2.charAt(left) - 'a']) ++matches;
                else if (s2Freq[s2.charAt(left) - 'a'] == s1Freq[s2.charAt(left) - 'a']) --matches;

                --s2Freq[s2.charAt(left) - 'a'];
                ++left;
            }

            if (s2Freq[s2.charAt(right) - 'a'] + 1 == s1Freq[s2.charAt(right) - 'a']) ++matches;
            else if (s2Freq[s2.charAt(right) - 'a'] == s1Freq[s2.charAt(right) - 'a']) --matches;

            if (matches == 26) return true;

            ++s2Freq[s2.charAt(right) - 'a'];
            ++right;
        }
        
        return false;
    }
}

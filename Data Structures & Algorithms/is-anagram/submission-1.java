class Solution {
    public boolean isAnagram(String s, String t) {

        // if length of 2 strings is diff then they can't be equal
        if (s.length() != t.length()) return false;

        // as both strings contain only english alphabets
        // we can create an array of size 26 (for each character from a to z)
        // integer array is automatically initialized with zeroes (0)
        int[] counter = new int[26];

        // iterate through first string and store elements at their 
        // correct index (0 for a, 1 for b by subtracting their ascii value from 97)
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // now store it at its correct index
            counter[ch - 'a']++;
        }

        // now loop through elements of 2nd array and decrement
        // the count of the each character present in 2nd string
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            // now decrement it in count array
            counter[ch - 'a']--;
        }

        // finally loop through it to see if every index has 0 in it meaning if 2 strings
        // had same characters the increment/decrement should balance it out
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) return false;
        }

        return true;
    }
}

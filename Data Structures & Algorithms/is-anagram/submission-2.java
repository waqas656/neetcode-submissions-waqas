class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26]; // 0 is auto added at every index because it is an integer array

        // fill array with characters count using s
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            int idx = ch - 'a';

            count[idx]++;
        }

        // fill array with characters count decrement using t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            int idx = ch - 'a';

            count[idx]--;
        }

        // if count at any index is not zero that means characters are not in equal numbers in both strings
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) return false;
        }

        return true;
    }
}

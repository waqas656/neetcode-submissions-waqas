class Solution {
    public boolean isPalindrome(String s) {
        int left = 0; // left most element in character array
        int right = s.length() - 1; // right most character in array
        
        // invariant: alpha-numeric elements to the right of right pointer
        // and left to the left pointer are the same
        while (left < right) {
            // first find the valid alpha-numeric characters on both ends to compare
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(right))) {
                --right;
                continue;
            }

            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            // once you have the valid characters, compare them
            if (leftChar != rightChar) return false;

            ++left;
            --right;
        }

        return true;
    }
}

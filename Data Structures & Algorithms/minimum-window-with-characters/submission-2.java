class Solution {
    public String minWindow(String s, String t) {
        // use frequency arrays of size 128 to hold both upper and lowecase letters
        // 1 frequency array for t, and second for window size
        // create a matches variable initially at 0
        // build frequency array for t, and maintain a required variable to store the distint characters by incrementing it only when value changes from 0 to 1
        // use left and right initially both at 0 index
        // loop until right becomes equal to s.length() and for each character:
        // if adding it to windows frequency array winFreq, makes it equal to tFreq array, increment matches by 1
        // keep incrementing until matches reach the size of distinct characters size
        // if matches reaches the required size, save that size to a min variable to track minimum window and also store those start and end indexes in 2 variables to get min substring at the end and incrementing left until window becomes invalid meaning matches and required are no longer equal
        // at the end find the minimum substring using the start and end indexes maintained throughout
        
        if (s.length() < t.length()) return "";

        int[] tfreq = new int[128];
        int[] winfreq = new int[128];

        int left = 0, right = 0;
        int matches = 0;
        int required = 0;
        int start = 0;
        int end = 0;
        int min = s.length() + 1;

        for (char ch : t.toCharArray()) {
            if (tfreq[ch] == 0) ++required;
            tfreq[ch]++;
        }

        while (right < s.length()) {
            char rchar = s.charAt(right);

            if (winfreq[rchar] + 1 == tfreq[rchar]) {
                ++matches;
            }

            ++winfreq[rchar];

            if (matches == required) {
                while (matches == required) {
                    int currWinSize = right - left + 1;
                    
                    if (currWinSize < min) {
                        min = currWinSize;
                        start = left;
                        end = right;
                    }

                    int lchar = s.charAt(left);
                    if (winfreq[lchar] == tfreq[lchar]){ 
                        --matches;
                    }

                    --winfreq[lchar];
                    ++left;
                }
            }

            ++right;
        }

        if (min == s.length() + 1) return "";
        return s.substring(start, end + 1);
    }
}

class Solution {
    public String minWindow(String s, String t) {
        int[] tfreq = new int[128];
        int required = 0;
        int matches = 0;

        for (char ch : t.toCharArray()) {
            if (tfreq[ch] == 0) ++required;
            ++tfreq[ch];
        }

        int left = 0;

        int[] winfreq = new int[128];

        int min = s.length() + 1;

        int start = 0, end = 0; // for noting the start & end indexes of min string

        for (int right = 0; right < s.length(); right++) {
            char rchar = s.charAt(right);

            if (winfreq[rchar] + 1 == tfreq[rchar]) ++matches;

            ++winfreq[rchar];

            // if window becomes valid, note the length and update min if applicable
            // keep removing from left until window becomes invalid (i-e) matches no longer equals to required
            while (matches == required) {
                int len = right - left + 1;
                    
                if (len < min) {
                    min = len;
                    start = left;
                    end = right;
                }

                int lchar = s.charAt(left);
                    
                if (winfreq[lchar] == tfreq[lchar]) --matches;

                --winfreq[lchar];

                ++left;
            }
        }
        
        if (min == s.length() + 1) return "";
        return s.substring(start, end + 1);
    }
}

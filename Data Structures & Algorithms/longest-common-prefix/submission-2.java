class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        // we take first word as starting point
        // compare it with next word until we find a common character(s)
        // or else return nothing

        String commonString = strs[0];

        for (int i = 1; i < strs.length; i++) {
            if (commonString.equals(strs[i])) continue;

            // remove last character from common string 
            // and compare with current string 
            // until we find a common substring
            int end = commonString.length() - 1;
            while (strs[i].indexOf(commonString) != 0) {
                commonString = commonString.substring(0, end);
                if (commonString.equals("")) return "";
                --end;
            }
        }
        
        return commonString;
    }
}
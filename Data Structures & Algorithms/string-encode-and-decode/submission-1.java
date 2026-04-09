class Solution {

    public String encode(List<String> strs) {
        // encode by first appending the length and then a delimiter like #
        // this way from the start of the string we will be sure to get the exact substring from the encoded string
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length() + "#");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        // extract the characters until '#'
        // then remove # from the string to get the length of encoded substring

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0; // iterator to traverse encoded string

        // invariant: when sb is empty, i will always be at the start of the encoded substring
        while (i < str.length()) {
            char ch = str.charAt(i);
            // 2#hi3#plz

            if (ch == '#') {
                // get the length of the next encoded substring
                int strLen = Integer.parseInt(sb.toString());

                // get the encoded substring
                String encSubStr = str.substring(i + 1, i + 1 + strLen);

                // add it to resultant list
                res.add(encSubStr);

                // reset the string builder for getting next substring's length
                sb.setLength(0);

                // increment the 'i'
                i = i + 1 + strLen;
            } else {
                sb.append(ch);
                i++;
            }
        }

        return res;
    }
}

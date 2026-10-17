class Solution {

    public String encode(List<String> strs) {
        // initialize string builder object
        StringBuilder sb = new StringBuilder();

        // loop over each string and add its count then '#' and then the string itself
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);   
        }

        // convert stringbuilder to string
        return sb.toString();
    }

    public List<String> decode(String str) {
        // initialize a variable to point at the start of string
        int start = 0;
        List<String> ls = new ArrayList<>();

        // loop until it is less than the length of the string
        // get a substring from current position + 2 until the start index value + 1
        // store values in a list
        while (start <= str.length() - 1) {
            // "Hello", "World" -> "5#Hello5#World"
            // get characters until '#'
            StringBuilder sb = new StringBuilder();
            char ch = str.charAt(start);

            while (ch != '#') {
                sb.append(ch);
                ++start;
                ch = str.charAt(start);
            }

            int strLen = Integer.parseInt(sb.toString());

            String s = str.substring(start + 1, start + strLen + 1);

            ls.add(s);

            start = start + strLen + 1;
        }

        return ls;
    }
}

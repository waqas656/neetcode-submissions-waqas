class Solution {
    public boolean isValidSudoku(char[][] board) {
        // store each row, column and box items in a set to check duplicates
        Set<Integer>[] rowSet = new Set[9];
        Set<Integer>[] colSet = new Set[9];
        Set<Integer>[] boxSet = new Set[9];

        // initialize sets
        for (int i = 0; i < rowSet.length; i++) {
            rowSet[i] = new HashSet<>();
        }

        for (int i = 0; i < colSet.length; i++) {
            colSet[i] = new HashSet<>();
        }

        for (int i = 0; i < boxSet.length; i++) {
            boxSet[i] = new HashSet<>();
        }

        // iterate and check duplicates in 9x9 2d array
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                // retrieve character
                char ch = board[row][col];

                // ignore if character is dot '.'
                if (ch != '.') {
                    // convert ch to integer
                    int chVal = Integer.parseInt(String.valueOf(ch));

                    // check if duplicate or not for each set
                    if (!rowSet[row].add(chVal)) return false;

                    if (!colSet[col].add(chVal)) return false;

                    // calculate box Index
                    int boxIdx = (((row/3) * 3) + (col/3));
                    if (!boxSet[boxIdx].add(chVal)) return false;
                }
            }
        }

        return true;
    }
}

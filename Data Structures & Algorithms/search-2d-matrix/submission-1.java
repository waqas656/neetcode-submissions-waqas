class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // initialize pointers start to 0, and end to matrix.length - 1
        // binary search on rows (while start <= end)
        // find mid and check if mid's first and last index (inclusive) have the target between as every row is in asc order
        // if target > row's last index, start = mid + 1
        // else if target < row's first index, end = mid - 1
        // else, you have found the candidate row, so implement another binary search here
        // initialize start to 0, end to row.length - 1
        // while start <= end, loop:
        // find mid
        // if target < element at mid index, end = mid - 1
        // else if target > element at mid index, start = mid + 1
        // else if target equal element at mid index return true
        // after inner loop ends, break outerloop
        // return false

        int start = 0;
        int end = matrix.length - 1;

        while (start <= end) {
            int outerMid = (start + end) / 2;

            if (target > matrix[outerMid][matrix[outerMid].length - 1]) start = outerMid + 1;
            else if (target < matrix[outerMid][0]) end = outerMid - 1;
            else {
                int left = 0;
                int right = matrix[outerMid].length - 1;

                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (target == matrix[outerMid][mid]) return true;
                    else if (target > matrix[outerMid][mid]) left = mid + 1;
                    else right = mid - 1;
                }

                break;
            }
        }
        
        return false;
    }
}

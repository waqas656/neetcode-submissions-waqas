class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // m = matrix.length -> total arrays/rows in matrix
        // n = matrix[0].length -> total columns in each row
        // set start = 0; end = (m * n) - 1
        // loop while start <= end
        // find mid by formula: start + (end - start)/2
        // find row by formula: mid/n
        // find col by formula: mid%n
        // if target == element at mid index -> return true
        // if target > element at mid index -> move start to mid + 1
        // if target < element at mid index -> move end to mid - 1
        // after loop ends, it means we were not able to find element inside matrix, return false

        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = (m * n) - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int row = mid / n;
            int col = mid % n;

            int num = matrix[row][col];

            if (target == num) return true;
            else if (target > num) start = mid + 1;
            else end = mid - 1;
        }

        return false;
    }
}

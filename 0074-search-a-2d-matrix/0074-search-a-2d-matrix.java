class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        // Step 1: Find correct row
        int low = 0;
        int high = m - 1;
        int row = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // target is smaller than first element of this row
            if (target < matrix[mid][0]) {
                high = mid - 1;
            }

            // target is greater than last element of this row
            else if (target > matrix[mid][n - 1]) {
                low = mid + 1;
            }

            // target lies inside this row
            else {
                row = mid;
                break;
            }
        }

        // No suitable row found
        if (row == -1) {
            return false;
        }

        // Step 2: Binary search inside that row
        low = 0;
        high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (matrix[row][mid] == target) {
                return true;
            }

            else if (matrix[row][mid] < target) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        return false;
    }
}
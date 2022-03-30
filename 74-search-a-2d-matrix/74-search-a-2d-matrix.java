class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int low = 0, high = matrix.length - 1;
        int n = matrix[0].length;
        
        while(low <= high) {
            int i = low + (high - low)/2;
            
            if (target >= matrix[i][0] && target <= matrix[i][n - 1]) {
                return binarySearch(matrix[i], target);
                
            } else if (target < matrix[i][0]) {
                high = i - 1;
                
            } else {
                low = i + 1;
            }
        }
        
        return false;
    }
    
    private boolean binarySearch(int[] mat, int target) {
        int left = 0, right = mat.length - 1;
        
        while(left <= right) {
            
            int mid = left + (right - left)/2;
            
            if (mat[mid] == target) return true;
            else if (mat[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        
        return false;
    }
}
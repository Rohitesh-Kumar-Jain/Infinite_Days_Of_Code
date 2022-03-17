class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] ans = new int[m][n];
        
        int i = 0, j = 0;
        
        while(i < m) {
            
            while(rowSum[i] > 0) {
                int val = Math.min(rowSum[i], colSum[j]);
                ans[i][j] += val;
                rowSum[i] -= val;
                colSum[j] -= val;
                if (rowSum[i] == 0) break;
                if (colSum[j] == 0) j++;
            }
            
            i++;
        }
        
        return ans;
    }
} 
 



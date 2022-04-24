class Solution {
    public int maxTrailingZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        int[][][] left = new int[m][n][2], right = new int[m][n][2], up = new int[m][n][2], down = new int[m][n][2];
        
        int[][][] cur = new int[m][n][2];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cur[i][j] = getMuls(i, j, grid);
            }
        }
        
        // for (int[][] c : cur) System.out.println(Arrays.deepToString(c));
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    if (j != 0) left[i][j][k] = cur[i][j-1][k] + left[i][j-1][k];
                    if (i != 0) up[i][j][k] = cur[i-1][j][k] + up[i-1][j][k];
                }
            }
        }
        
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                for (int k = 0; k < 2; k++) {
                    if (j != n-1) right[i][j][k] = cur[i][j+1][k] + right[i][j+1][k];
                    if (i != m-1) down[i][j][k] = cur[i+1][j][k] + down[i+1][j][k];
                }
            }
        }
        
        // for (int[][] c : down) System.out.println(Arrays.deepToString(c));
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // top-left
                int two = cur[i][j][0] + up[i][j][0] + left[i][j][0];
                int five = cur[i][j][1] + up[i][j][1] + left[i][j][1];
                ans = Math.max(ans, Math.min(two, five));
                
                // top-right
                two = cur[i][j][0] + up[i][j][0] + right[i][j][0];
                five = cur[i][j][1] + up[i][j][1] + right[i][j][1];
                ans = Math.max(ans, Math.min(two, five));
                
                // down-left
                two = cur[i][j][0] + down[i][j][0] + left[i][j][0];
                five = cur[i][j][1] + down[i][j][1] + left[i][j][1];
                ans = Math.max(ans, Math.min(two, five));
                
                // down-right
                two = cur[i][j][0] + down[i][j][0] + right[i][j][0];
                five = cur[i][j][1] + down[i][j][1] + right[i][j][1];
                ans = Math.max(ans, Math.min(two, five));
            }
        }
        
        return ans;
    }
    
    private int[] getMuls(int i, int j, int[][] grid) {
        int[] ans = new int[2];
        int two = 0, five = 0;
        
        int val = grid[i][j];
        
        while(val % 5 == 0) {
            five++;
            val = val/5;
        }
        
        while(val % 2 == 0) {
            two++;
            val = val/2;
        }
        
        ans[0] = two; ans[1] = five;
        return ans;
    }
}
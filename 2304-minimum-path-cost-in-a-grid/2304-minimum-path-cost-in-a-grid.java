class Solution {
    
    Integer[][] memo;
    
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int ans = Integer.MAX_VALUE;
        int m = grid.length, n = grid[0].length;
        this.memo = new Integer[m][n];
        
        if (m == 0 || n == 0) return 0;
        
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp(0, j, grid, moveCost));
        }
        
        return ans;
    }
    
    private int dp(int i, int j, int[][] grid, int[][] move) {
        if (i == grid.length - 1) {
            return grid[i][j];
        }
        
        if (memo[i][j] != null) return memo[i][j];
        
        int op = Integer.MAX_VALUE;
        int cur = grid[i][j];
        for (int col = 0; col < grid[0].length; col++) {
            op = Math.min(op, dp(i+1, col, grid, move) + move[cur][col]);
        }
        
        return memo[i][j] = op + cur;
    }
}
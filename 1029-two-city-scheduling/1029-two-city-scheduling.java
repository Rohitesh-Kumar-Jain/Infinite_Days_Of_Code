class Solution {
    int n;
    int max = Integer.MAX_VALUE;
    int[][] costs;
    Integer[][][] memo;
    public int twoCitySchedCost(int[][] costs) {
        n = costs.length/2;
        this.costs = costs;
        
        memo = new Integer[2*n + 1][n + 1][n + 1];
        
        return dp(0, n, n);
    }
    
    private int dp(int i, int a, int b) {
        if (i >= 2* n && a == b) {
            return 0;
        }
        if (a < 0 || b < 0) return max;
        
        if (memo[i][a][b] != null) return memo[i][a][b];
        
        int op1 = dp(i + 1, a - 1, b);
        if (op1 != max) op1 += costs[i][0];
        
        int op2 = dp(i + 1, a, b - 1);
        if (op2 != max) op2 += costs[i][1];
        
        return memo[i][a][b] = Math.min(op1, op2);
    }
}
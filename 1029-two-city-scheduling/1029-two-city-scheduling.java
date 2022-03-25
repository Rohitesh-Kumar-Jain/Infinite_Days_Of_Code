class Solution {
    int n;
    int max = Integer.MAX_VALUE;
    int[][] costs;
    Integer[][] memo;
    public int twoCitySchedCost(int[][] costs) {
        n = costs.length/2;
        this.costs = costs;
        
        memo = new Integer[2*n + 1][n + 1];
        
        return dp(0, n);
    }
    
    private int dp(int i, int a) {
        if (i >= 2* n && a == 0 && 2*n - i - a == 0) {
            return 0;
        }
        if (a < 0 || 2*n - i - a < 0) return max;
        
        if (memo[i][a] != null) return memo[i][a];
        
        int op1 = dp(i + 1, a - 1);
        if (op1 != max) op1 += costs[i][0];
        
        int op2 = dp(i + 1, a);
        if (op2 != max) op2 += costs[i][1];
        
        return memo[i][a] = Math.min(op1, op2);
    }
}
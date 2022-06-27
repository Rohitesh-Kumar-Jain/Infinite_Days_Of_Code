class Solution {
    
    int d = 1_000_000_007;
    
    public int countHousePlacements(int n) {
        long[] dp = new long[n+1];
        dp[1] = 2;
        if (n == 1) return 4;
        dp[2] = 3;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]%d + dp[i-2]%d;
            dp[i] = dp[i]%d;
        }
        
        return (int)((dp[n]*dp[n])%d);
    }
}
class Solution {
    
    private int inf = Integer.MAX_VALUE;
    Integer[][] memo;
    
    public int minDifficulty(int[] jd, int d) {
        this.memo = new Integer[jd.length][d];
        int ans = dp(0, d-1, jd);
        return ans == inf ? -1 : ans;
    }
    
    private int dp(int lastCut, int cuts, int[] jd) {
        if (cuts == -1 && jd.length == lastCut) return 0;
        if (cuts < 0 || jd.length - lastCut <= cuts || lastCut >= jd.length) return inf;
        
        if (memo[lastCut][cuts] != null) return memo[lastCut][cuts];
        
        int max = 0;
        int diff = inf;
            
        for (int i = lastCut; i < jd.length; i++) {
            max = Math.max(max, jd[i]);
            int op1 = dp(i + 1, cuts - 1, jd);
            op1 += op1 == inf ? 0 : max;
            diff = Math.min(diff, op1);
        }
        
        return memo[lastCut][cuts] = diff;
    }
}
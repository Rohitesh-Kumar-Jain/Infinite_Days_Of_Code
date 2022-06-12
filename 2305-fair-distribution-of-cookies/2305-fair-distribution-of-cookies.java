class Solution {
    
    public int distributeCookies(int[] cookies, int k) {
        int[] divs = new int[k];
        
        return dp(0, divs, cookies);
    }
    
    private int dp(int i, int[] divs, int[] cookies) {
        if (i == cookies.length) {
            int max = 0;
            for (int val : divs) max = Math.max(max, val);
            return max;
        }
        
        int op = Integer.MAX_VALUE;
        
        for (int j = 0; j < divs.length; j++) {
            divs[j] += cookies[i];
            op = Math.min(op, dp(i+1, divs, cookies));
            divs[j] -= cookies[i];
        }
        
        return op;
    }
}
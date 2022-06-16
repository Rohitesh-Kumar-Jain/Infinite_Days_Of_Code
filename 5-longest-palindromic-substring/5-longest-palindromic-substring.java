class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;
        int start = 0, end = 0;
        int res = 1;
        
        boolean[][] dp = new boolean[n][n];
        
        for (int i = 0; i < n; i++) dp[i][i] = true;
        
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                start = i;
                end = i + 1;
                dp[i][i + 1] = true;
                res = 2;
            }
        }
        
        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                
                if (dp[i][j] == true) {
                    if (j - i >= res) {
                        start = i;
                        end = j;
                    }
                }
            }
        }
        
        return s.substring(start, end + 1);
    }
}
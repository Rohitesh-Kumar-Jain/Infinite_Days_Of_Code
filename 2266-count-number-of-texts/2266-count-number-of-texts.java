class Solution {
    
    Long[] memo;
    String s;
    int d = 1_000_000_007;
    int len;
    
    public int countTexts(String pressedKeys) {
        s = pressedKeys;
        len = s.length();
        this.memo = new Long[len + 1];
        
        long ans = dp(0);
        // System.out.println(ans);
        return (int)ans;
    }
    
    private long dp(int i) {
        if (i == len) return 1;
        if (memo[i] != null) return memo[i] % d;
        
        // single press
        long op1 = dp(i + 1);
        long op2 = 0, op3 = 0, op4 = 0;
        
        // double press
        if (i + 1 < len && s.charAt(i) == s.charAt(i + 1)) {
            op2 = dp(i + 2);
            op2 %= d;
            
            // three press
            if (i + 2 < len && s.charAt(i) == s.charAt(i + 2)) {
                op3 = dp(i + 3);
                op3 %= d;
                
                // four press
                if (i + 3 < len && s.charAt(i) == s.charAt(i + 3) && (s.charAt(i) == '7' || s.charAt(i) == '9')) {
                    op4 = dp(i + 4);
                    op4 %= d;
                }
            }
        }
        
        // System.out.println(op1 + " " + op2 + " " + op3 + " " + op4);
        
        return memo[i] = ((op1 + op2)%d + (op3 + op4)%d) % d;
    }
}
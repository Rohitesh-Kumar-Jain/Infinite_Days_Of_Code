class Solution {
    
    String s1, s2, ans;
    int res;
    
    public String minimizeResult(String expression) {
        this.ans = ""; this.res = Integer.MAX_VALUE;
        String[] exp = expression.split("\\+"); 
        this.s1 = exp[0]; this.s2 = exp[1];
       
        help(0, s2.length());
        return ans;
    }
    
    private void help(int l, int r) {
        if (l >= s1.length() || r <= 0) return;
            
        int mul1 = 1, mul2 = 1, sum1 = 0, sum2 = 0;
        
        if (!s1.substring(0, l).equals("")) mul1 = Integer.parseInt(s1.substring(0, l));
        if (!s1.substring(l, s1.length()).equals("")) sum1 = Integer.parseInt(s1.substring(l, s1.length()));
        if (!s2.substring(0, r).equals("")) sum2 = Integer.parseInt(s2.substring(0, r));
        if (!s2.substring(r, s2.length()).equals("")) mul2 = Integer.parseInt(s2.substring(r, s2.length()));
        
        int cur = (sum1 + sum2) * mul1 * mul2;
        
        if (cur < res) {
            ans = s1.substring(0, l) + "(" + s1.substring(l, s1.length()) + "+" + s2.substring(0, r) + ")" + s2.substring(r, s2.length());
            res = cur;
        }
        
        help(l + 1, r); help(l, r - 1);
    }
}
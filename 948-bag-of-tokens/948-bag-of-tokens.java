class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int ans = 0, cur = 0;
        Arrays.sort(tokens);
        int l = 0, r = tokens.length - 1;
        
        while(l <= r) {
            if (power >= tokens[l]) {
                cur++;
                ans = Math.max(ans, cur);
                power -= tokens[l++];
                
            } else if (cur > 0) {
                cur--;
                power += tokens[r--];
                
            } else {
                break;
            }
        }
        
        return ans;
    }
}
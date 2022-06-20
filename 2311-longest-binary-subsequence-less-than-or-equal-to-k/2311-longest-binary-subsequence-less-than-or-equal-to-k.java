class Solution {
    public int longestSubsequence(String s, int k) {
        int j = 0;
        long ans = 0, count = 0, val = 0;
        
        for (int i = 0; i < s.length(); i++) {
            count++;
            char ch = s.charAt(i);
            val = val*2;
            val += ch == '0' ? 0 : 1;
            // System.out.println(i + " " + val + " " + ans);
            while (val > k && j <= i) {
                while(j <= i && s.charAt(j) == '0') j++;
                val -= Math.pow(2, i - j);
                count--; j++;
            }
            ans = Math.max(ans, count);
        }
        
        return (int)ans;
    }
}